package com.kay.service.impl;

import com.kay.dao.IAccountDao;
import com.kay.domain.Account;
import com.kay.service.IAccountService;
import com.kay.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务的控制都应该在业务层，而不应该在持久层
 */
public class AccountServiceImpl_OLD implements IAccountService {

    private IAccountDao accountDao;

    private TransactionManager txManager;

    public void setAccountDao(IAccountDao accoutDao) {
        this.accountDao = accoutDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() {

        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;

        }catch (Exception e){
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源连接
            txManager.release();
        }

    }

    public Account findAccountById(Integer accountId) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return account;

        }catch (Exception e){
            //5.回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();


        }catch (Exception e){
            //4.回滚事务
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //5.释放资源连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //4.回滚事务
            txManager.rollback();
        }finally {
            //5.释放资源连接
            txManager.release();
        }

    }

    public void deleteAccount(Integer account) {
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(account);
            //3.提交事务
            txManager.commit();

        }catch (Exception e){
            //4.回滚事务
            txManager.rollback();
        }finally {
            //5.释放资源连接
            txManager.release();
        }

    }

    public void transfer(String sourceName,String targetName,Float money){
        try{
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            {
                //1.根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //3.转出账户减钱
                source.setMoney(source.getMoney() - money);
                //4.转入账户加钱
                target.setMoney(target.getMoney() + money);
                //5.更新转出账户
                accountDao.updateAccount(source);
                int i = 5/0;
                //6.更新转出账户
                accountDao.updateAccount(target);
            }
            //3.提交事务
            txManager.commit();


        }catch (Exception e){
            //4.回滚事务
            txManager.rollback();
            e.printStackTrace();
        }finally {
            //5.释放资源连接
            txManager.release();
        }

    }

    public void test() {

    }
}
