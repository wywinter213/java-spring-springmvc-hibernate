package com.shop.dao.impl;

import com.shop.dao.CategoryDao;
import com.shop.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("CategoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {
    @Override
    public Date queryPrivilegeTime(Integer cid) {
        return null;
    }
}
