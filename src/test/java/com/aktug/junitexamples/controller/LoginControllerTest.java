package com.aktug.junitexamples.controller;

import com.aktug.junitexamples.exceptions.UserNotFoundException;
import com.aktug.junitexamples.model.User;
import com.aktug.junitexamples.service.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

public class LoginControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private LoginController loginController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAuhtentication() throws Exception {

        final User userStub = new User();
        userStub.setUsername("a00432028");
        userStub.setPassword("*****");

        Mockito.when(userService.authenticate(userStub)).thenReturn(true);

        final String redirect = loginController.authenticate(userStub);
        Assert.assertEquals("homePage", redirect);
        Mockito.verify(userService, new Times(1)).authenticate(Mockito.any(User.class));

    }


    @Test
    public void testAuhtenticationForUserNotFound() throws Exception {
        final User userStub = new User();
        userStub.setUsername("a00432028");
        userStub.setPassword("*****");

        Mockito.when(userService.authenticate(userStub)).thenThrow(UserNotFoundException.class);

        final String redirect = loginController.authenticate(userStub);
        Assert.assertEquals(redirect, "errorPage?message=userNotFound");
        Mockito.verify(userService, new Times(1)).authenticate(Mockito.any(User.class));
    }

}