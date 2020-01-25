package com.ping.dao;

import com.ping.domain.Account;
import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/21-21:25
 */
public interface AccountUserDao {
    /**
     * 查询所有账号信息对应的用户名和地址
     * @return
     */
//    List<AccountUser> findAll();
      List<Account> findAll();
}
