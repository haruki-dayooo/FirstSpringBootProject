package com.springdemo.springbootproject.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

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

    @PostMapping("/login")
    User login(@RequestParam String userId, @RequestParam String password) {
        Optional<User> user = userRepository.checkLoginUser(userId, password);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user.get();
    }
}
