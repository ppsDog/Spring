package com.service.impl;

import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//<bean id="userService" class="com.service.impl.UserServiceImpl"></bean>
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${driver}")
    private  String name;

    // 依赖注入
    // <property name="userDao" -> Autowired    ref="userDao" -> Qualifier></property>
    @Autowired              // 按照数据类型从Spring容器中进行匹配的
    @Qualifier("userDao")   // 是按照id值从容器中进行匹配的,但是主要此处 @Qualifier 结合@Autowired一起使用
   // @Resource(name = "userDao")  // @Resource相当于 @Autowired + @Qualifier
    private UserDao userDao;

    public void save() {
        userDao.save();
        System.out.println(name);
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁....");
    }
}
