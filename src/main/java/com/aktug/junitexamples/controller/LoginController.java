package com.aktug.junitexamples.controller;


import com.aktug.junitexamples.exceptions.UserNotFoundException;
import com.aktug.junitexamples.model.User;
import com.aktug.junitexamples.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class LoginController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    String authenticate(final User user) {

        try {
            if (userService.authenticate(user)) {
                return "homePage";
            } else {
                return "errorPage?message=wrongPassword";
            }
        } catch (UserNotFoundException e) {
            logger.error("User not found for usernmae: {}", user.getUsername(), e);
            return "errorPage";
        }
    }

}