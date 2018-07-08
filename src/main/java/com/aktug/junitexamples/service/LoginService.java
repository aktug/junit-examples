package com.aktug.junitexamples.service;

import com.aktug.junitexamples.dao.UserDao;
import com.aktug.junitexamples.model.User;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {
    @Autowired
    private UserDao userDao;

    public boolean login(String userName, String userPassword) {
        User user = userDao.findUserByName(userName);
        return user.getUsername().equals(userName) && user.getPassword().equals(userPassword);

    }
}
