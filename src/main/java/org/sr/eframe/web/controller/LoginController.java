package org.sr.eframe.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.sr.eframe.service.UserService;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:53:42}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: LoginController
 * @Description:
 * 
 * 
 */
@Controller
public class LoginController {

	@Resource
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		if (userService.isSystemUser(username, password)) {
			request.getSession().setAttribute("user", username);
			mv.setViewName("redirect:/manager/portal");
		} else {
			mv.setViewName("forward:/");
			mv.addObject("username", username);
			mv.addObject("message", "账户名或密码错误");
		}
		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {

		request.getSession().removeAttribute("user");
		return new ModelAndView("redirect:/manager/portal");
	}
}
