package com.example.datajpa.demo.service;

import com.example.datajpa.demo.model.User;
import com.example.datajpa.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        userService = new UserService(userRepository);
    }

    @Test
    public void findUser_WhenFoundUser_ThenShountBetrue() throws Exception {
        List<User> users = setUsers("test");
        doReturn(users).when(userRepository).findByName("test");

        boolean loginResult = userService.findUser("test");

        assertTrue(loginResult);
        verify(userRepository, times(1)).findByName("test");
    }

    @Test
    public void findUser_WhenNotFoundUser_ThenShountBeFalse() throws Exception {
        List<User> users = setUsers("test");
        doReturn(users).when(userRepository).findByName("test");

        boolean loginResult = userService.findUser("not found");

        assertFalse(loginResult);
        verify(userRepository, times(1)).findByName("not found");
    }

    private List<User> setUsers(String name) {
        List<User> users = new ArrayList<User>();
        User user = new User(name, "test");
        users.add(user);
        return users;
    }
}
