package com.shop.dao;

import com.shop.model.Category;

import java.util.Date;

public interface CategoryDao extends BaseDao<Category> {
    /**
     * 查询优惠时间
     *
     * @param cid
     * @return
     */
    public Date queryPrivilegeTime(Integer cid);
}
