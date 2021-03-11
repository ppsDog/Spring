package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

// 切面类
public class MyAspect {
    public void before(){
        System.out.println("前置增强...");
    }

    public void afterRunning(){
        System.out.println("后置增强...");
    }

    // ProceedingJoinPoint:正在执行的连接点==>切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        Object proceed = pjp.proceed();  //切点方法
        System.out.println("环绕后...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常增强...");
    }

    public void after(){
        System.out.println("最终增强...");
    }


}
