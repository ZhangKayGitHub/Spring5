package com.kay.dao;

import com.kay.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAcountDao {

    /**
     * 根据Id查找账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查找账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
