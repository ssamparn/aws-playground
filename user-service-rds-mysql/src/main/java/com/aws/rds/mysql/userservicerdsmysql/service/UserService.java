package com.aws.rds.mysql.userservicerdsmysql.service;

import com.aws.rds.mysql.userservicerdsmysql.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> fetchAllUsers();

    User getUserById(Long id);

    User updateUserById(Long id, User employee);

    String deleteUserById(Long id);
}
