package com.demo;

import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");

        userService.save();


//        UserService userService = new UserServiceImpl();
//        // NullPointerException,没有从容器中拿出来,自己new出来的,没有userDao参数
//        userService.save();


    }
}
