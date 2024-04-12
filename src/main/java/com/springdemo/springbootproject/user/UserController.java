package com.springdemo.springbootproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/find")
    User findById(@RequestParam String userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user.get();
    }

    @GetMapping("/search")
    List<User> searchByFullName(@RequestParam String search) {
        return userService.searchByFullName(search);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/create")
    void create(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    User login(@RequestBody User user) {
        Optional<User> checkLogin = userService.checkLoginUser(user.getUserId(), user.getPassword());
        if (checkLogin.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return checkLogin.get();
    }
}
