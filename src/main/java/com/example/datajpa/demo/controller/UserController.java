package com.example.datajpa.demo.controller;

import com.example.datajpa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info/{name}")
    public boolean checkUserExist(@PathVariable(value = "name") String name) {
        if(StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("Name can't empty.");
        }
        return userService.findUser(name);
    }
}
