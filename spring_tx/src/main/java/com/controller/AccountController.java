package com.controller;


import com.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {
    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = app.getBean(AccountService.class);
        bean.transfer("zhangsan","lisi",100);

    }
}
