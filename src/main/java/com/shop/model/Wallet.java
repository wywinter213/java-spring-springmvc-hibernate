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
    @JoinColumn(name = "uid")
    private User user;
}
