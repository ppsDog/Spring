package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TargetController{

    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行.....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","zhangsan");
        modelAndView.setViewName("index");
        return modelAndView;
    }



}