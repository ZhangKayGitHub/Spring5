package com.kay.factory;

import com.kay.service.IAccountService;
import com.kay.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能存在与jar包中的，我们无法通过修改源码的方式案例提供默认的构造函数）
 */

public class StaticFactory {

    public static IAccountService getAccountService (){
        return new AccountServiceImpl();
    }
}
