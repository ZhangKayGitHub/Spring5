package com.kay.test;

import com.kay.dao.IAccountDao;
import com.kay.domain.Account;
import com.kay.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit 单元测试，测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    IAccountService as;

    @Test
    public void testFindAll() {
        //1.获取容器
       //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
       // IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        //1.获取容器
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
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
      //  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
       // IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.saveAccout(account);
    }

    @Test
    public void testUpdate() {
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
       // IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setName("kay");
        account.setMoney(65432F);
        as.updateAccount(account);
        System.out.println(account);

    }
    @Test
    public void testDelete() {
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
       // IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        as.deleteAccount(4);
    }

}
