package com.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 切面类
@Component("myAspect")
@Aspect     // 标注当前MyAspect是一个切面类
public class MyAspect {

    //  定义切点表达式
    @Pointcut("execution(* com.anno.*.*(..))")
    public void pointcut(){

    }

    // 配置前置增强
    @Before("execution(* com.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }

    @AfterReturning("pointcut()")
    public void afterRunning(){
        System.out.println("后置增强...");
    }

    // ProceedingJoinPoint:正在执行的连接点==>切点
    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        Object proceed = pjp.proceed();  //切点方法
        System.out.println("环绕后...");
        return proceed;
    }

    @AfterThrowing("execution(* com.anno.*.*(..))")
    public void afterThrowing(){
        System.out.println("异常增强...");
    }

    @After("execution(* com.anno.*.*(..))")
    public void after(){
        System.out.println("最终增强...");
    }


}
