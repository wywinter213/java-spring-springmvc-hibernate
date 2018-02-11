package com.shop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  `uid` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(255) DEFAULT NULL,
 `password` varchar(255) DEFAULT NULL,
 `minventory` int(11) NOT NULL,
 */

@Entity
@Table(name = "adminuser")
public class Admin implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String username;
    private String password;
    private Integer minventory;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMinventory() {
        return minventory;
    }

    public void setMinventory(Integer minventory) {
        this.minventory = minventory;
    }
}
