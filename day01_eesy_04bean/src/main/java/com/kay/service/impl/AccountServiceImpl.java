package com.kay.service.impl;


import com.kay.service.IAccountService;

/**
 * 账户业务层实现类
 */

public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }

    public void saveAccount() {
        System.out.println("service中的savaAcount方法执行了!");
    }
    public void init(){
        System.out.println("对象初始化了。。。。");
    }
    public void destory(){
        System.out.println("对象销毁了。。。。。");
    }
}
