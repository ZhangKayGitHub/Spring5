package com.kay.ui;

import com.kay.dao.IAccountDao;
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
     * 获取spring的Ioc 核心容器，并根据id获取对象
     *
     * ApplocationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求是配置文件必须在类路径下，不在的话，加载不了
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须具有访问权限）
     *      AnnotationConfigApplicationContext：它是读取注解创建容器的
     *
     * 核心容器两个接口引发的问题：
     *      ApplicationContext:         单例对象适用      由于BeanFactory是一个顶层接口实现的功能较少所以在实际开发中还是选择ApplicationContext接口
     *          它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读完配置文件马上 就创建配置文件中配置的对象。
     *      BeanFactory:                多例对象适用
     *          它在创建核心容器时，创建对象采取的策略是采用延迟加载的方式，也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\Kay\\Desktop\\bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
        //as.saveAccount();

/*
        //---------------BeanFactory 配置文件中的类对象延迟加载测试------------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = factory.getBean("accountService");
        System.out.println(as);
*/
   }
}
