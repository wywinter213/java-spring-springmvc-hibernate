package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *`oid` int(11) NOT NULL AUTO_INCREMENT,
 `addr` varchar(255) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `ordertime` datetime DEFAULT NULL,
 `phone` varchar(255) DEFAULT NULL,
 `state` int(11) DEFAULT NULL,
 `total` float DEFAULT NULL,
 `uid` int(11) DEFAULT NULL,
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer oid;

    @Column(length = 255, columnDefinition = "varchar")
    private String addr;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ordertime;
    private String phone;

    private Integer state;
    private Float total;

    //一个用户可以有多个订单 ，是多对一的关系
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    //与orderitem表是一对多关系
    @OneToMany()
    private Set<OrderItem> orderItems;

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
