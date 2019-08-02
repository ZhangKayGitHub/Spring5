package com.kay.dao.impl;

import com.kay.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public AccountDaoImpl2(){
        System.out.println("AccountDaoImple2对象创建成功！");
    }

    public void saveAccount() {
        System.out.println("保存了账户222222222222");
    }
}
