package com.example.datajpa.demo.controller;

import com.example.datajpa.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {

    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        userController = new UserController(userService);
    }

    @Test
    public void checkUserExist_WhenCall_ThenSuccess() throws Exception {
        doReturn(true).when(userService).findUser("test");

        boolean userFound = userController.checkUserExist("test");

        assertTrue(userFound);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkUserExist_WhenCallNotParam_ThenThrowException() throws Exception {
        userController.checkUserExist("");
    }
}
