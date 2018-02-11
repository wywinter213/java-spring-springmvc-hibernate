package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * `itemid` int(11) NOT NULL AUTO_INCREMENT,
 `count` int(11) DEFAULT NULL,
 `subtotal` float DEFAULT NULL,
 `oid` int(11) DEFAULT NULL,
 `pid` int(11) DEFAULT NULL,
 */
@Entity
@Table(name = "orderitem")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemid;

    private Integer count;
    private Float subtotal;

    //与order表是多对一的关系
    @ManyToOne(optional = false)
    @JoinColumn(name = "oid")
    private Order order;

    //与product表是多对一的关系
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid")
    private Product product;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
