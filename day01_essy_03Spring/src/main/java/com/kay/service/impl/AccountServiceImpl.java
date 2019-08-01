package com.kay.service.impl;

import com.kay.dao.IAccountDao;
import com.kay.dao.impl.AccountDaoImpl;

import com.kay.service.IAccountService;

/**
 * 账户业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

   private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了！");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
