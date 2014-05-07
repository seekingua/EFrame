package org.sr.eframe.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:52:03}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: LoginInterceptor
 * @Description:
 * 
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		request.setCharacterEncoding("UTF-8");
		if (request.getSession().getAttribute("user") != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
	}

}
