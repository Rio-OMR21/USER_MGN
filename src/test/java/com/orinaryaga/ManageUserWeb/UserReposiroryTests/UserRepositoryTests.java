package com.orinaryaga.ManageUserWeb.UserReposiroryTests;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.orinaryaga.ManageUserWeb.domain.User;
import com.orinaryaga.ManageUserWeb.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setFname("Lauro");
        user.setLname("Mahemba");
        user.setGender("Female");
        user.setAge(87);
        user.setEmail("LauroKiringo@gmail.com");
        user.setMobile(555555);
        user.setAddress("Kwao,Kwao,Kwao");
        user.setPin(2222);

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isPositive();
    }

    @Test
    public void testListAll() {
        Iterable<User> user = repo.findAll();
        Assertions.assertThat(user).hasSizeGreaterThan(0);

        for (User usera : user) {
            System.out.print(usera);
        }

    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPin(7777);
        repo.save(user);

        User updatedUser = repo.findById(userId).get();
        Assertions.assertThat(updatedUser.getPin()).isEqualTo(7777);

    }

    @Test
    public void testGet() {
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }

    @Test
    public void testDelete() {
        Integer userId = 1;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();

    }

}
