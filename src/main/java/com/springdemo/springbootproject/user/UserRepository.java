package com.springdemo.springbootproject.user;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    List<User> findAll() {
        return users;
    }

    @PostConstruct
    private void init() {
        users.add(new User("admin", "1", "bo may la admin", "AD"));
        users.add(new User("hoadoan", "1", "Hoa Doan", "US"));
    }

    Optional<User> findById(String userId) {
        return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
    }

    Optional<User> checkLoginUser(String userId, String password) {
        return users.stream().filter(user -> user.getUserId().equals(userId) && user.getPassword().equals(password)).findFirst();
    }
}
