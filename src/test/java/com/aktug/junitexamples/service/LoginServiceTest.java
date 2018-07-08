package com.aktug.junitexamples.service;


import com.aktug.junitexamples.dao.UserDao;
import com.aktug.junitexamples.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private LoginService loginService;

    @Test
    public void shouldTrueIfUserNameAndPasswordIsTrue() {
        String userName = "a00432028";
        String userPassword = "*****";

        User user = new User();
        user.setUsername("a00432028");
        user.setPassword("*****");

        when(userDao.findUserByName(userName)).thenReturn(user);
        when(userDao.save(user)).thenReturn(user);

        Assert.assertTrue(loginService.login(userName, userPassword));
    }

}
