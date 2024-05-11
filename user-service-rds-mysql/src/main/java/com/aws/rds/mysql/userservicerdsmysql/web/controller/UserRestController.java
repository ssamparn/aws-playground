package com.aws.rds.mysql.userservicerdsmysql.web.controller;

import com.aws.rds.mysql.userservicerdsmysql.entity.User;
import com.aws.rds.mysql.userservicerdsmysql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping("/create")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        return userService.updateUserById(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUserById(userId);
    }
}
