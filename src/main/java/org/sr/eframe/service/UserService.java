package org.sr.eframe.service;

import org.springframework.data.domain.Page;
import org.sr.eframe.model.User;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:44:06}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: UserService
 * @Description:
 * 
 * 
 */

public interface UserService extends BaseService<User> {

	public Page<User> findByUsernameLike(String username, Integer pageNo);

	public boolean isSystemUser(String username, String password);

	public boolean saveUser(User user, String login);
}
