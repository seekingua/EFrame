package org.sr.eframe.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:53:50}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: PortalController
 * @Description:
 * 
 * 
 */
@Controller
@RequestMapping("/manager")
public class PortalController {

	@RequestMapping("/portal")
	public ModelAndView portal(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("portal/show").addObject("first", "首页").addObject("second", "门户");
		mav.addObject("sidebar", "portal");
		mav.addObject("user", request.getSession().getAttribute("user"));
		return mav;
	}
}
