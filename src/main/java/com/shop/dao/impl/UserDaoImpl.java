package com.shop.dao.impl;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public User findByUsername(String userName) {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public User findByCode(String code) {
        return null;
    }

    public void save(){


    }

}
