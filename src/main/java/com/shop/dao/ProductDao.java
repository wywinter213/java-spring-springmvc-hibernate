package com.shop.dao;

import com.shop.model.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {

    /**
     * 根据二级分类查询商品
     *
     * @param csid
     * @param page
     * @return
     */
    public List<Product> findByCategorySecondCsid(Integer csid, Integer page);

    /**
     * 根据一级分类查询商品
     *
     * @param cid
     * @param page
     * @return
     */
    public List<Product> findByCategorySecondCategoryCid(Integer cid, Integer page);

    public Integer CountPageProductFromCategory(Integer cid);

    public Integer CountPageProductFromCategorySecond(Integer csid);
}
