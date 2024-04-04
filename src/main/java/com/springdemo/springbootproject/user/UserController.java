package com.springdemo.springbootproject.user;

import com.springdemo.springbootproject.user.User;
import com.springdemo.springbootproject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/findAll")
    List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/find")
    User findById(@RequestParam String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/create")
    void create(@RequestBody User user) {
        userRepository.create(user);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    User login(@RequestBody User user) {
        Optional<User> checkLogin = userRepository.checkLoginUser(user.getUserId(), user.getPassword());
        if (checkLogin.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return checkLogin.get();
    }
}
