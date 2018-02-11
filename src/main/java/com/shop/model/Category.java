package com.shop.model;

import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * `cid` int(11) NOT NULL,
 `cname` varchar(255) DEFAULT NULL,
 `discount` float DEFAULT NULL,
 `privilegeTime` datetime NOT NULL COMMENT '优惠时间'
 */

@Entity
@Table(name="category")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;

    private String cname;

    private Float discount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date privilegeTime;

    //一对多
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
    @OrderBy(value="csid")//使用categorySeconds的主键排序
    private Set<CategorySecond> categorySeconds;

    //一对一
//    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "category")
//    private Ticket ticket;

//    public Ticket getTicket() {
//        return ticket;
//    }
//
//    public void setTicket(Ticket ticket) {
//        this.ticket = ticket;
//    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Date getPrivilegeTime() {
        return privilegeTime;
    }

    public void setPrivilegeTime(Date privilegeTime) {
        this.privilegeTime = privilegeTime;
    }

    public Set<CategorySecond> getCategorySeconds() {
        return categorySeconds;
    }

    public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
        this.categorySeconds = categorySeconds;
    }
}
