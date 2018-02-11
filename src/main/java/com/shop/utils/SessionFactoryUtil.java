package com.shop.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

/**
 * 封装hibernate sessionfactory的定义和使用
 */
public class SessionFactoryUtil {

    private static final SessionFactory sessionFactory;
    private Transaction transaction = null;

    static {
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }


    public SessionFactoryUtil() {
    }

    /**
     * 获取sessionfactory实例
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }

//    public static Transaction getTransaction(){
//
//    }
}
