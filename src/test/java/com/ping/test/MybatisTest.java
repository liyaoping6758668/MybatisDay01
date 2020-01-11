package com.ping.test;

import com.ping.dao.UserDao;
import com.ping.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author:lyp
 * @date 2020/1/11-13:09
 * mybatis入门案例
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.创建sqlsession
        SqlSession sqlSession = factory.openSession();
        //4.通过sqlsession创建接口代理对象（相当于创建接口实现类）
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user:userList) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();


    }
}
