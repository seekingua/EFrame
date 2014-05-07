package org.sr.eframe.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.sr.eframe.model.User;
import org.sr.eframe.service.UserService;
import org.sr.eframe.util.EframeUtil;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:54:03}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: UserController
 * @Description:
 * 
 * 
 */
@Controller
@RequestMapping(value = "/manager/system/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/mod/user")
	public ModelAndView mod(User user, HttpSession session) {

		String login = session.getAttribute("user").toString();
		if (user.getId() != null) {
			user = this.userService.update(user, login);
		} else {
			if (!this.userService.saveUser(user, login)) {
				return new ModelAndView("system/user/mod").addObject("message", "用户已存在，请更正");
			}
		}
		return new ModelAndView("redirect:/manager/system/user/list");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(Integer pageNo, User user) {

		this.userService.delete(user);
		return new ModelAndView("redirect:/manager/system/user/list");
	}

	@RequestMapping(value = "/list")
	public ModelAndView listAll(Integer pageNo, User user) {

		ModelAndView mav = new ModelAndView("system/user/list");
		Page<User> page = null;
		if (!EframeUtil.isNull(user.getUsername())) {
			page = userService.findByUsernameLike(user.getUsername(), EframeUtil.getPageNo(pageNo));
		} else {
			page = userService.findAll(EframeUtil.getPageNo(pageNo));
		}
		mav.addObject("user", user);
		EframeUtil.pageHandler(mav, page, "sys_user", EframeUtil.getPageNo(pageNo));
		mav.addObject("first", "首页").addObject("second", "用户管理");
		return mav;
	}

	@RequestMapping(value = "/mod")
	public ModelAndView toMod(Integer id) {

		ModelAndView mv = new ModelAndView("system/user/mod");
		User user = null;
		if (id != null) {
			user = this.userService.findOne(new User(id));
		} else {
			user = new User();
		}
		mv.addObject("sidebar", "sys_user").addObject("user", user).addObject("first", "首页").addObject("second", "用户管理").addObject("third", "用户修改");
		return mv;
	}

}
