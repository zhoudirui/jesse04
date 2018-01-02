package com.jesse04.case04.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesse04.case04.jpa.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountDao  extends JpaRepository<Account,Integer> {
}
