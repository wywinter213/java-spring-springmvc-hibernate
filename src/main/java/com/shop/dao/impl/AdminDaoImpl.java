package com.shop.dao.impl;

import com.shop.dao.AdminDao;
import com.shop.model.Admin;
import org.springframework.stereotype.Repository;

@Repository("AdminDao")
@SuppressWarnings("all")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

    @Override
    public Admin findByAdminnameAndPassword(String username, String password) {
        return null;
    }
}
