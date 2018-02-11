package com.shop.dao;

import com.shop.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class BaseDaoTest {
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction transaction = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before
    public void setUp() throws Exception {
        Configuration cfg = new Configuration();

        // 读取指定的配置文件
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();

        //开启事务
        transaction = session.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() throws Exception {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void save() {
        User user = new User();
        user.setAddr("北京朝阳区");
        user.setAge(36);
        user.setPhone("13311012030");
        user.setCode("123456ddddd");
        user.setEmail("372871265@qq.com");
        user.setPassword("123123");
        user.setName("wangyong");
        user.setUsername("wywinter");
        session.save(user);
    }

    @Test
    public void delete() {
        User user = session.get(User.class, 6);
        System.out.println(user.getEmail());
        session.delete(user);
    }

    @Test
    public void delete1() {

    }

    @Test
    public void update() {
    }

    @Test
    public void saveOrUpdate() {
    }

    @Test
    public void get() {
    }

    @Test
    public void find() {
    }

    @Test
    public void find1() {
    }

    @Test
    public void find2() {
    }

    @Test
    public void find3() {
    }

    @Test
    public void count() {
    }

    @Test
    public void count1() {
    }

    @Test
    public void count2() {
    }

    @Test
    public void executeHql() {
    }

    @Test
    public void executeHql1() {
    }

    @Test
    public void findByUid() {
    }

    @Test
    public void findTicketByCid() {
    }
}