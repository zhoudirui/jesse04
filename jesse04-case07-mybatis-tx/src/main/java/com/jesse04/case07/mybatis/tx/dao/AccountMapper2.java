package com.jesse04.case07.mybatis.tx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by fangzhipeng on 2017/4/20.
 */

public interface AccountMapper2 {
   @Update("update account set money = #{money} where id = #{id}")
   int update( @Param("money") double money, @Param("id") int  id);
}
