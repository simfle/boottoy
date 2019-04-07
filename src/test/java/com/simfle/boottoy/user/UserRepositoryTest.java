package com.simfle.boottoy.user;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User();
        user.setPassword("USER05");
        user.setUsername("USER05");
        userRepository.save(user);
    }

    @Ignore
    @Test
    public void getUser(){
        String username = "USER05";
        Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent(u -> Assert.assertEquals(u.getUsername(), username));
    }
}
