package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * `wid` int(11) NOT NULL,
 `money` float NOT NULL,
 `uid` int(11) DEFAULT NULL
 */
@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer wid;

    private Float money;

    //与用户表一对一关系
    @OneToOne(optional = false)
    @JoinColumn(name = "uid", unique = true)
    private User user;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "wid=" + wid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
