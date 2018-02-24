package com.shop.dao.impl;

import com.shop.dao.OrderDao;
import com.shop.model.Order;
import org.springframework.stereotype.Repository;

@Repository("OrderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
}
