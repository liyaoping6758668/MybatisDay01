package com.ping.dao;

import com.ping.domain.Role;

import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/28-10:17
 */
public interface RoleDao {
    public List<Role> findAll();
}
