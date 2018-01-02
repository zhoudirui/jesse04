package com.jesse04.case05.beatlsql.dao;

import org.beetl.sql.core.annotatoin.SqlStatement;
import org.beetl.sql.core.mapper.BaseMapper;

import com.jesse04.case05.beatlsql.entity.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountDao extends BaseMapper<Account> {

    @SqlStatement(params = "name")
    Account selectAccountByName(String name);
}
