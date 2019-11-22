package com.hzero.demo.ssm.dao;

import com.hzero.demo.ssm.pojo.User;

import java.util.List;

public interface UserDao {

    int insertUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    User findUserById(int userId);

    User findUserByName(String name);

    List<User> findAllUser();


}
