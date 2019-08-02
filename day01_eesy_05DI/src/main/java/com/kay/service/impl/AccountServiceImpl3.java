package com.kay.service.impl;


import com.kay.service.IAccountService;

import java.util.*;

/**
 * 账户业务层实现类
 */

public class AccountServiceImpl3 implements IAccountService {

    private String[] mystrs;
    private List<String> mylist;
    private Set<String> myset;
    private Map<String, String> myMap;
    private Properties myProperties;

    public void setMystrs(String[] mystrs) {
        this.mystrs = mystrs;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    public void saveAccount() {

        System.out.println("service中的savaAcount方法执行了!" + Arrays.toString(mystrs) );
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(myMap);
        System.out.println(myProperties);
    }
}
