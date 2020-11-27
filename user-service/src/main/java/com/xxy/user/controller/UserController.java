package com.xxy.user.controller;

import com.xxy.user.pojo.User;
import com.xxy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("{id}")
    public User queryById(@PathVariable Long id) {
        return userService.queryById(id);
    }

}
