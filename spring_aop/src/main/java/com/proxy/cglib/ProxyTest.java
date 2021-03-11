package com.proxy.cglib;

import com.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        final Target target = new Target();

        final Advice advice = new Advice();

        // 返回值就是动态生成的代理对象 基于cglib
        // 1.创建增强器
        Enhancer enhancer = new Enhancer();

        // 2.设置父类(目标)
        enhancer.setSuperclass(Target.class);

        // 3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 前置增强
                advice.before();
                method.invoke(target, args);     // 执行目标方法
                // 后置增强
                advice.afterRunning();
                return null;
            }
        });

        // 4.创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();

    }
}
