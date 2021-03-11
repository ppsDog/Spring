package com.factory;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
