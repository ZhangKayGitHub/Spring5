package com.kay.dao.impl;

import com.kay.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public AccountDaoImpl(){
        System.out.println("AccountDaoImple对象创建成功！");
    }

    public void saveAccount() {
        System.out.println("保存了账户111111111");
    }
}
