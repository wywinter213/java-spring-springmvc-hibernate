package com.shop.dao;

import com.shop.model.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    public User findByUsername(String userName);

    /**
     * 根据用户名和密码查找用户
     * @param userName
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String userName, String password);

    /**
     * 根据激活码查询用户
     *
     * @param code
     * @return
     */
    public User findByCode(String code);

}
