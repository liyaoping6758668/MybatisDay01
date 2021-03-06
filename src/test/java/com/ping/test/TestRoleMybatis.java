package com.ping.test;

import com.ping.dao.AccountDao;
import com.ping.dao.RoleDao;
import com.ping.domain.Account;
import com.ping.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/19-21:31
 */
public class TestRoleMybatis {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private RoleDao roleDao;
    /**
     * 初始化配置
     */
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.创建sqlsession
        sqlSession = factory.openSession();
        //4.通过sqlsession创建接口代理对象（相当于创建接口实现类）
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    /**
     * 释放资源
     */
    @After
    public void destory() throws IOException {
        sqlSession.commit();//提交事务
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void findAll() {
        List<Role> roleList = roleDao.findAll();
        for (Role role:roleList) {
            System.out.println(role);
        }

    }
}
