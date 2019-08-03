package com.kay.test;

import com.kay.domain.Account;
import com.kay.service.IAccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 测试queryRunner是否是一个单例
 */
public class QueryRunnerTest {
    @Test
    public void testFindAll() {
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取QueryRunner对象
        QueryRunner runner = ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner",QueryRunner.class);
        System.out.println(runner == runner1);//Spring 容器中的QueryRunner 是一个单例对象


    }

}
