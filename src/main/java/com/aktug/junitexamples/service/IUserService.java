package com.aktug.junitexamples.service;


import com.aktug.junitexamples.exceptions.UserNotFoundException;
import com.aktug.junitexamples.model.User;


public interface IUserService {

    boolean authenticate(final User user) throws UserNotFoundException;

}