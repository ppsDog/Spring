package com.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();

        // 读取web.xml中全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

        // 将Spring的应用上下文对象存储到 ServletContext 域中
        servletContext.setAttribute("app",app);
        System.out.println("Spring容器创建完毕");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
