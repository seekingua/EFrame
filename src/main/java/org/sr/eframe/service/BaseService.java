package org.sr.eframe.service;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:43:49}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: BaseService
 * @Description:
 * 
 * 
 * @param <T>
 */
public interface BaseService<T> {

	public void save(T t, String login);

	public void delete(T t);

	public T update(T t, String login);

	public T findOne(T t);

	public List<T> findAll();

	public Page<T> findAll(Integer pageNo);

}
