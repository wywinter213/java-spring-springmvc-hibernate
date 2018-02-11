package com.shop.service;

import com.shop.model.User;

import java.util.Set;

public interface UserService {
    public Boolean insert() throws Exception;
    public Boolean update() throws Exception;
    public Boolean delete() throws Exception;
    public Set<User> findAll() throws Exception;

}
