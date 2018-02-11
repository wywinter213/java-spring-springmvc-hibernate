package com.shop.dao.impl;


import com.shop.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

@Repository("BaseDao")
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T>{

    private SessionFactory sessionFactory;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        //识别当前操作的实体类
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];

        // to do list
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable save(T o) {
        return null;
    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void delete(T o) {

    }

    @Override
    public void update(T o) {

    }

    @Override
    public void saveOrUpdate(T o) {

    }

    @Override
    public T get(Serializable id) {
        return null;
    }

    @Override
    public List<T> find(String hql) {
        return null;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        return null;
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        return null;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        return null;
    }

    @Override
    public Integer count(String hql) {
        return null;
    }

    @Override
    public Integer count(String hql, Integer id) {
        return null;
    }

    @Override
    public Integer count(String hql, Map<String, Object> params) {
        return null;
    }

    @Override
    public Integer executeHql(String hql) {
        return null;
    }

    @Override
    public Integer executeHql(String hql, Map<String, Object> params) {
        return null;
    }

    @Override
    public Integer findByUid(Integer uid) {
        return null;
    }

    @Override
    public Integer findTicketByCid(Integer cid) {
        return null;
    }
}
