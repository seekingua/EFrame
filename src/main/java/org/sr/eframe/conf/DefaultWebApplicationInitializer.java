package org.sr.eframe.conf;

import java.io.IOException;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.sr.eframe.util.EframeUtil;

/**
 * @Organ: Inspur Group
 * @Teams: Big Data Team
 * @Author: zhouzhd {2014年4月28日 下午2:52:11}
 * @Mail: zzd338@163.com
 * 
 * @ClassName: DefaultWebApplicationInitializer
 * @Description:
 * 
 * 
 */
public class DefaultWebApplicationInitializer implements WebApplicationInitializer {

	private final static String DISPATCHER_SERVLET_NAME = "dispatcher";
	private final static String DISPATCHER_SERVLET_MAPPING = "/";

	private final static String ENCODING = "utf-8";
	private final static String ENCODEING_FILTER_NAME = "encodefilter";
	private final static String ENCODEING_FILTER_MAPPING = "/*";

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		// spring dispatcher
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

		// coding filter
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding(ENCODING);
		encodingFilter.setForceEncoding(true);
		FilterRegistration.Dynamic encodingFilterRegistration = servletContext.addFilter(ENCODEING_FILTER_NAME, encodingFilter);
		encodingFilterRegistration.addMappingForUrlPatterns(null, true, ENCODEING_FILTER_MAPPING);

		if (!System.getProperty("os.name").contains("Windows")) {
			try {
				Runtime.getRuntime().exec("chmod -R 755 " + EframeUtil.getParentPath("conf"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
