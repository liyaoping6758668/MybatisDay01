package com.ping.test;

import com.ping.dao.UserDao;
import com.ping.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/11-13:09
 * mybatis入门案例
 */
public class MybatisTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;
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
        userDao = sqlSession.getMapper(UserDao.class);
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
       /* //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.创建sqlsession
        SqlSession sqlSession = factory.openSession();
        //4.通过sqlsession创建接口代理对象（相当于创建接口实现类）
        UserDao userDao = sqlSession.getMapper(UserDao.class);*/
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
        /*//6.释放资源
        sqlSession.close();
        in.close();*/
    }
    /**
     * 保持用户
     */
    @Test
    public void saveUser(){
        User user=new User();
        user.setUsername("liyaoping");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东阳江");
        userDao.saveUser(user);
    }

    /**
     * 更新用户
     */
    @Test
    public void updateUser(){
        User user=new User();
        user.setId(53);
        user.setUsername("liyaoping1");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("广东阳江1");
        userDao.updateUser(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){

        userDao.deleteUser(53);
    }

    /**
     * 根据id查询用户所有信息
     */
    @Test
    public void findById(){

        User user = userDao.findById(48);
        System.out.println(user);
    }

    /**
     * 根据用户名称模糊查询
     */
    @Test
    public void findByName(){

        List<User> users = userDao.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }
}
