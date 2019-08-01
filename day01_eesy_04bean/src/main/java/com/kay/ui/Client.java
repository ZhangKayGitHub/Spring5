package com.kay.ui;

import com.kay.service.IAccountService;
import com.kay.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.awt.*;

/**
 * 模拟一个表现层用于调用业务层
 */

/**
 * 控制反转（Inversion of Control 英文缩写为IOC，该对象把创建对象额权力交给了框架或工厂的重要特征，并非面向对象编程的专用术语，
 * 它包括依赖注入（Dependency Injection, 简称DI）和依赖查找（Dependency Lookup）
 *
 * 明确一下ioc 的作用：削减计算机程序的耦合，(解除我们代码间的依赖关系)
 */

public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as);
//        System.out.println(as1);
        as.saveAccount();
        //手动关闭容器
        ac.close();

   }
}
