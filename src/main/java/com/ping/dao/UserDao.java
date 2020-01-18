package com.ping.dao;

import com.ping.domain.User;
import com.ping.domain.UserPojo;

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

    /**
     * 根据id查询用户信息
     */
    User findById(int userid);

    /**
     * 根据用户名称模糊查询
     */
    List<User> findByName(String username);
//    List<User> findByName(UserPojo userPojo);

    /**
     * 查询总记录数
     */
    int findTotal();

    /**
     * 根据查询条件拼接sql
     */
    List<User> findByCondition(User user);

    /**
     * 根据多个id查询用户信息
     */
    List<User> findByListId(UserPojo userPojo);
}
