package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * `pacid` int(11) NOT NULL COMMENT '卡包编号',
 `uid` int(11) NOT NULL COMMENT '客户编号'
 */
@Entity
@Table(name = "packet")
public class Packet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pacid;

    //一个客户有一个卡包，是一对一的外键关系
    @OneToOne(optional = false)
    @JoinColumn(name = "uid", unique = true)
    private User user;

    public Integer getPacid() {
        return pacid;
    }

    public void setPacid(Integer pacid) {
        this.pacid = pacid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
