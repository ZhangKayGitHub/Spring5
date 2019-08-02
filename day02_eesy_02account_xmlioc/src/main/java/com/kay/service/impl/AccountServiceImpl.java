package com.kay.service.impl;

import com.kay.dao.IAccountDao;
import com.kay.domain.Account;
import com.kay.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accoutDao) {
        this.accountDao = accoutDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccout(Account account) {
        accountDao.saveAccout(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer account) {
        accountDao.deleteAccount(account);
    }
}
