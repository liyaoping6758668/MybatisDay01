package com.ping.dao;

import com.ping.domain.User;

import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/10-23:21
 * 用户信息接口
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户信息
     */
    void saveUser(User user);

    /**
     * 更新用户
     */
    void updateUser(User user);

    /**
     * 删除用户
     */
    void deleteUser(int userid);
}
