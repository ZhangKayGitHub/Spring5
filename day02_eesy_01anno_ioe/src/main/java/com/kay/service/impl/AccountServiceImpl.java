package com.kay.service.impl;

import com.kay.dao.IAccountDao;
import com.kay.dao.impl.AccountDaoImpl;

import com.kay.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户业务层实现类
 * 曾经XML的配置
 *  <bean id="accountService" class="com.kay.service.impl.AccountServiceImpl"
 *          scope="" init-method="" destory-method="">
 *      <property name="" value="" | ref=""></property>
 *  </bean>
 *
 *  用于创建对象的
 *      他们的作用就和XML配置文件中编写一个<bean>标签实现的功能时一样的
 *      Component:
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id，当我们不写时，他默认是当前类名，且首字母改为小写
 *       Controller：一般用在表现层
 *       Service：一般用在业务层
 *       Repository：一般用在持久层
 *       以上三个注解他们的作用和属性与Component是一模一样，
 *       为什么还要有者三个注解呢？
 *       他们三个是spring框架为我们提供明确的三层使用的注解使我们三层对象更加清晰
 *
 *  用于注入数据的
 *      他们的作用和在XML配置文件中bean标签中写一个<property>标签的作用是一样的
 *      Autowrited：
 *          作用：自动按照类型注入只要容器中有唯一的一个bean对象类型和要注入的变量类型的匹配，就可以注入成功
 *                  如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *                  如果Ioc容器有多个类型匹配时：
 *
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解时，set方法就不是必须的了
 *     Qualifier：
 *          作用：在按照类中注入的基础之上再按照名称注入，它在给类成员注入时不能单独使用，但是在给方法参数注入时可以单独使用
 *          属性：
 *              value：指定注入bean的id。
 *     Resource：
 *          作用：直接按照bean的id注入，可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *      以上三个注入都只能注入其他bean类型的数据，而基本数据类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xml来实现
 *
 *      Value
 *          作用：用于注入基本类型的String类型的数据
 *          属性：
 *              value：用于指定数据的值，它可以使用spring中SpEL（也就是spring 的el 表达式）
 *                      SpEL的写法：${表达式}
 *
 *
 *  用于改变作用范围的
 *      他们的作用就和在bean标签中使用scope属性实现的功能是一样的
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值，常用取值：singleton    prototype
 *  用于生命周期相关的
 *      他们的作用就和在bean标签中使用init-method和 destory-method的作用是一样的
 *      PreDestroy
 *          作用：用于指定初始化方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */

@Component(value = "accountService")//如果只有一个value值的话，value关键字可以不写
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao1")
   private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了！！");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁方法执行了！！");
    }
}
