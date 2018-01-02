package com.jesse04.case07.mybatis.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jesse04.case07.mybatis.tx.dao.AccountMapper2;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
@Service
public class AccountService2 {

    @Autowired
    AccountMapper2 accountMapper2;

    @Transactional
    public void transfer() throws RuntimeException{
        /**
         * 进行事务操作 发现异常则进行回滚操作
         *
         */
        accountMapper2.update(90.0,1);//用户1减10块 用户2加10块
        //int i=1/0; // 此打开则处抛出异常，事务管理发现异常而回滚操作，上步操作进行回滚
        //System.out.println("coming transfer() method ");
        accountMapper2.update(110.0,2);
    }
}
