package com.anno;

import org.springframework.stereotype.Component;

// 目标类
@Component("target")
public class Target implements TargetInterface {
    public void save() {
       // int i = 1/0;
        System.out.println("save running .....");
    }
}
