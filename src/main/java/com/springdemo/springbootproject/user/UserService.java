package com.springdemo.springbootproject.user;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> searchByFullName(String search) {
        return userRepository.searchByFullName(search);
    }

    public Optional<User> findById(String userId) {
        return userRepository.findById(userId);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> checkLoginUser(String userId, String password) {
        return userRepository.checkLoginUser(userId, password);
    }
}
