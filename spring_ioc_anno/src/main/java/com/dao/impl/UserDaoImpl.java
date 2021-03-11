package com.dao.impl;

import com.dao.UserDao;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.dao.impl.UserDaoImpl"></bean>
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save创建.....");
    }
}
