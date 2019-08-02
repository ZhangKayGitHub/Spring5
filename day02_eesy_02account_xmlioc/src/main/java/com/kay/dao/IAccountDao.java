package com.kay.dao;

import com.kay.domain.Account;

import java.util.List;

/**
 * 持久层的接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param account
     */
    void saveAccout(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param account
     */
    void deleteAccount(Integer account);
}
