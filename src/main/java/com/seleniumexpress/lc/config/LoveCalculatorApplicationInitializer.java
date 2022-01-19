package com.seleniumexpress.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer //implements WebApplicationInitializer
{

	public void onStartup(ServletContext servletContext) throws ServletException {

		/*
		 * // create a dispatcher servlet object XmlWebApplicationContext
		 * webApplicationContext = new XmlWebApplicationContext();
		 * 
		 * webApplicationContext.setConfigLocation("classpath:spring-mvc-servlet.xml");
		 * 
		 * DispatcherServlet dispatcherServlet = new
		 * DispatcherServlet(webApplicationContext);
		 * 
		 * // register dispatcher servlet with servlet context object
		 * 
		 * ServletRegistration.Dynamic myCustomDispatcher =
		 * servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		 * myCustomDispatcher.setLoadOnStartup(1);
		 * myCustomDispatcher.addMapping("/mywebsite.com/*");
		 */
		
		AnnotationConfigWebApplicationContext webApplicationContext=new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculaterAppConfig.class);
		DispatcherServlet dispatcherServlet=new DispatcherServlet(webApplicationContext);
		ServletRegistration.Dynamic myCustomDispatcherServlet=servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
		
	}

}
