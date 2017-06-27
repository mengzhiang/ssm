package com.zhiang.dao;

import com.zhiang.po.User;
import com.zhiang.ssm.domain.UserDO;
import com.zhiang.ssm.mapper.UserDOMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UserDaoTest {

    @Test
    public void findUserById() {
        SqlSession sqlSession = getSessionFactory().openSession();
        //UserDao userMapper = sqlSession.getMapper(UserDao.class);
        //User user = userMapper.findUserById(2);
        //System.out.println(user.getId()+user.getName()+user.getPassword());
        //Assert.assertNotNull("没找到数据", user);
        UserDOMapper userDOMapper = sqlSession.getMapper(UserDOMapper.class);
        UserDO userDO = userDOMapper.selectByPrimaryKey(2);
        System.out.println(userDO);

    }

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

}