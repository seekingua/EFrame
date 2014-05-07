package org.sr.eframe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.sr.eframe.model.User;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 上午9:51:56}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: UserRepository
 * @Description:
 * 
 * 
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * @Author: zhouzhd {2014年4月28日 下午2:37:03}
	 * @Version：
	 * @Title: findByUsernameContaining
	 * @Description: 名称模糊查询
	 * @param username
	 * @param pageable
	 * @return
	 */
	Page<User> findByUsernameContaining(String username, Pageable pageable);

	/**
	 * @Author: zhouzhd {2014年4月28日 下午2:37:20}
	 * @Version：
	 * @Title: findByUsernameAndPasswd
	 * @Description: 根据用户名和密码查询
	 * @param username
	 * @param passwd
	 * @return
	 */
	@Query(value = "select * from sys_user u where binary u.username = ?1 and binary u.passwd = ?2", nativeQuery = true)
	User findByUsernameAndPasswd(String username, String passwd);

	/**
	 * @Author: zhouzhd {2014年5月7日 下午5:15:10}
	 * @Version：
	 * @Title: findByUsername
	 * @Description:
	 * 
	 * @param username
	 * @return
	 */
	@Query(value = "select * from sys_user u where binary u.username = ?1", nativeQuery = true)
	User findByUsername(String username);
}