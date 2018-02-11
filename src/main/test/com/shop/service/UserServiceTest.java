package com.shop.service;

import com.shop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private SessionFactory sf;
    private Session session;
    @Before
    public void setUp() throws Exception {
        //加载主配置文件，并且创建session的工厂
        sf=new Configuration().configure("spring/spring-hibernate.xml").buildSessionFactory();
        session = sf.openSession();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setAddr("北京朝阳区");
        user.setAge(36);
        user.setPhone("13311012030");
        user.setCode("123456");
        user.setEmail("372871265@qq.com");
        user.setPassword("123123");
        user.setName("wangyong");
        user.setUsername("wywinter");
        session.save(user);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }
}