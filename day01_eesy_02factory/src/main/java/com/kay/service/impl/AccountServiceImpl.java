package com.kay.service.impl;

import com.kay.dao.IAccountDao;
import com.kay.dao.impl.AccountDaoImpl;
import com.kay.factory.Beanfactory;
import com.kay.service.IAccountService;

/**
 * 账户业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)Beanfactory.getBean("accountDao");

    private int i = 1;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
