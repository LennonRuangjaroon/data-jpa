package com.example.datajpa.demo.service;

import com.example.datajpa.demo.model.User;
import com.example.datajpa.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean findUser(String name){
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()){
            return false;
        }
        return true;
    }


}
