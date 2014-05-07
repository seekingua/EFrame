package org.sr.eframe.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.Properties;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:53:20}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: EframeUtil
 * @Description:
 * 
 * 
 */
public class EframeUtil {

	public static final String HOST = "UUID";

	private static Properties prop = new Properties();
	static {
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conf"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int pageSize = 8;

	public static int getPageNo(Integer pageNo) {

		return pageNo == null || pageNo < 1 ? 0 : pageNo - 1;
	}

	public static <T> void pageHandler(ModelAndView mav, Page<T> page, String sideBar, Integer pageNo) {

		mav.addObject("sidebar", sideBar);
		mav.addObject("pageNo", pageNo + 1);
		mav.addObject("length", page.getTotalPages());
		mav.addObject("page", page);
	}

	/**
	 * @Author: zhouzhd {2014年7月30日 上午9:19:27}
	 * @Version：
	 * @Title: isNull
	 * @Description: 判断字符错是否为空或者空串(包括之含有空格的串)
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNull(String str) {
		return ((str == null) || (str.trim().length() == 0));
	}

	/**
	 * @Author: zhouzhd {2014年7月31日 下午4:33:33}
	 * @Version：
	 * @Title: excludeLastChar
	 * @Description: 字符串去除最后一个字符
	 * 
	 * @param str
	 * @return
	 */
	public static String excludeLastChar(String str) {
		if (!isNull(str)) {
			return str.substring(0, str.length() - 1);
		}
		return null;
	}

	public static BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {

		return new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
	}

	/**
	 * @Author: zhouzhd {2014年8月4日 上午10:04:09}
	 * @Version：
	 * @Title: getPath
	 * @Description: 获取指定文件目录
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getPath(String fileName) throws IOException {

		try {
			return new File(Thread.currentThread().getContextClassLoader().getResource(fileName).toURI()).getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Author: zhouzhd {2014年8月4日 上午10:05:01}
	 * @Version：
	 * @Title: getParentPath
	 * @Description: 获取指定文件的父目录
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String getParentPath(String fileName) throws IOException {

		try {
			return new File(Thread.currentThread().getContextClassLoader().getResource(fileName).toURI()).getParent();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getValue(String key) {

		return (String) prop.get(key);
	}

	public static String getMethodName(String fieldName, String prefix) {

		return prefix + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object getUpdateObject(Object newObj, Object oldObj) {

		try {
			Class clazz = newObj.getClass();
			Object value = null;
			for (Field field : clazz.getDeclaredFields()) {
				value = clazz.getMethod(getMethodName(field.getName(), "get")).invoke(newObj);
				if (value != null) {
					clazz.getMethod(getMethodName(field.getName(), "set"), field.getType()).invoke(oldObj, value);
				}
			}
			return oldObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}