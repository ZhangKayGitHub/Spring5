package com.kay.ui;

import com.kay.factory.Beanfactory;
import com.kay.service.IAccountService;
import com.kay.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层用于调用业务层
 */

/**
 * 这种工厂的开发发模式存在着很强的类与类之间的依赖关系
 */

public class Client {
    public static void main(String[] args) {
        /**
         * 控制反转（Inversion of Control 英文缩写为IOC，该对象把创建对象额权力交给了框架或工厂的重要特征，并非面向对象编程的专用术语，
         * 它包括依赖注入（Dependency Injection, 简称DI）和依赖查找（Dependency Lookup）
         *
         * 明确一下ioc 的作用：削减计算机程序的耦合，(解除我们代码间的依赖关系)
         */

        //IAccountService as = new AccountServiceImpl();
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) Beanfactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
//        as.saveAccount();
   }
}
