package com.shop.dao.impl;

import com.shop.dao.ProductDao;
import com.shop.model.Product;

import java.util.List;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
    @Override
    public List<Product> findByCategorySecondCsid(Integer csid, Integer page) {
        return null;
    }

    @Override
    public List<Product> findByCategorySecondCategoryCid(Integer cid, Integer page) {
        return null;
    }

    @Override
    public Integer CountPageProductFromCategory(Integer cid) {
        return null;
    }

    @Override
    public Integer CountPageProductFromCategorySecond(Integer csid) {
        return null;
    }
}
