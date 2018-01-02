package com.jesse04.case03.jdbc.service;

import java.util.List;

import com.jesse04.case03.jdbc.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface IAccountService {


    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();

}
