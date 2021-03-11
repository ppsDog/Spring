package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;

// 标志该类时Spring的核心配置类
@Configuration
//  <context:component-scan base-package="com"></context:component-scan>
@ComponentScan("com")
//  <import resource="xxx.xml"></import>
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {


}
