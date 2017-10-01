package com.example.datajpa.demo.integration.repository;

import com.example.datajpa.demo.integration.IntegrationTest;
import com.example.datajpa.demo.model.Phone;
import com.example.datajpa.demo.model.User;
import com.example.datajpa.demo.repository.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DataJpaTest
public class UserRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void insertUser_whenInsert_ThenShouldBeSuccess() throws Exception {
        List<Phone> initPhone = setUpPhone();

        userRepository.save(new User("test", "test", initPhone));

        List<User> users = userRepository.findByName("test");
        for (User user : users) {
            assertEquals("test", user.getName());
        }
    }

    @Test
    public void findByName_WhenCallFindByTest_ThenReturnTestUser() throws Exception {
        List<Phone> initPhone = setUpPhone();
        User user = entityManager.persist(new User("test", "test", initPhone));

        List<User> users = userRepository.findByName("test");

        assertTrue(users.contains(user));
    }

    private List<Phone> setUpPhone() {
        Phone phone = new Phone("IPhone");
        List<Phone> initPhone = new ArrayList<>();
        initPhone.add(phone);
        return initPhone;
    }
}
