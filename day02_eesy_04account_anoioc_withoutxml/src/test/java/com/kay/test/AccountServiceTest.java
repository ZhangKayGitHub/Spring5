package com.kay.test;

import com.kay.domain.Account;
import com.kay.service.IAccountService;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit 单元测试，测试我们的配置
 *
 * 应用程序的入口
 *      main方法
 *  junit单元测试中，没有main方法也能执行
 *      junit集成了一个main方法
 *      该方法就会判断当前测试类中哪些方法有@Test注解
 *      junit就让有Test注解的方法执行
 *  3.junit不会管我们是否采用spring框架
 *      在执行测试方法时，junit根本不知道我们是不是使用spring框架
 *      所以就不会为我们读取配置文件/配置类创建spring核心容器
 *  4.由以上三点可知
 *      当测试方法执行时，没有Ioc容器，就算写了Autowrite注解，也无法实现注入
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {


    //private ApplicationContext ac;
    @Autowired
    private IAccountService as;
    /**
     * 下边的注解和代码是通过Junit提供的main方法进行加载的，该Junit的main方法并不会自加载Spring中的核心容器
     * 因此在需要在init这种初始化spring的核心容器，由于在测试人员测试的时候，并不会执行整个方法，只是执行方法中的部分代码，
     * 在执行部分代码的时候没有核心容器，因此在执行时会发生异常。
     * 下面将下边的Junit的初始化代码注释掉，采用另外的一种方式（利用Spring中的main方法来替代Junit中的main方法来运行）
     *
     * Spring 整合junit的配置
     *      1.在pom.xml文件中导入spring整合的junit的jar（坐标）
     *      2.使用Junit提供的一个注解把原有的main方法替换掉，替换成spring提供的（spring提供的main方法可以加载spring核心容器）
     *          RunWith
     *      3.告知spring的运行容器，spring和ioc创建时基于xml还是注解的，并且说明位置
     *          ContextConfiguration
     *              location：指定xml文件的位置，加上classpath关键字，表示在类路径下
     *              classes：指定在注解类所在位置
     * 注意：
     *      当我们使用Spring5。x版本的时候，要求junit的jar包必须是4.12及以上
     */

//    @Before
//    public void init(){
//        //1.获取容器
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.得到业务层对象
//        as = ac.getBean("accountService",IAccountService.class);
//    }



    @Test
    public void testFindAll() {
        //1.获取容器
//        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        //1.获取容器
       // ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
      //  IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
            System.out.println(account);
    }
    @Test
    public void testsave() {

        Account account = new Account();
        account.setName("test");
        account.setMoney(123456F);
        //1.获取容器
      //  ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
     //   IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
      //  ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
     //   IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(5);
        account.setName("kay");
        account.setMoney(65432F);
        as.updateAccount(account);
        System.out.println(account);

    }
    @Test
    public void testDelete() {
   //     ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
    //    IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.deleteAccount(5);
    }

}
