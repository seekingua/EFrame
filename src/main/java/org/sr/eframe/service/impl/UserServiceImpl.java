package org.sr.eframe.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.sr.eframe.model.User;
import org.sr.eframe.repository.UserRepository;
import org.sr.eframe.service.UserService;
import org.sr.eframe.util.EframeUtil;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:50:17}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: UserServiceImpl
 * @Description:
 * 
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	public boolean saveUser(User user, String login) {

		if (this.userRepository.findByUsername(user.getUsername()) == null) {
			user.setCreateTime(new Date());
			user.setCreator(login);
			this.userRepository.save(user);
			return true;
		}
		return false;
	}

	public void delete(User user) {

		this.userRepository.delete(user.getId());
	}

	public User update(User user, String login) {

		user.setEditTime(new Date());
		user.setEditor(login);
		return this.userRepository.save((User) EframeUtil.getUpdateObject(user, this.findOne(user)));
	}

	public List<User> findAll() {

		return this.userRepository.findAll();
	}

	public Page<User> findAll(Integer pageNo) {

		return this.userRepository.findAll(new PageRequest(pageNo, EframeUtil.pageSize));
	}

	public User findOne(User user) {

		return this.userRepository.findOne(user.getId());
	}

	public Page<User> findByUsernameLike(String username, Integer pageNo) {

		return this.userRepository.findByUsernameContaining(username, new PageRequest(pageNo, EframeUtil.pageSize));
	}

	public boolean isSystemUser(String username, String password) {

		if (this.userRepository.findByUsernameAndPasswd(username, password) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void save(User t, String login) {
		// TODO Auto-generated method stub

	}

}
