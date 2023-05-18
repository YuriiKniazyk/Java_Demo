package com.yuriikniazyk.demo.controllers;

import com.yuriikniazyk.demo.db.entities.User;
import com.yuriikniazyk.demo.models.UserRequestModel;
import com.yuriikniazyk.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService = new UserService();

    @PostMapping()
    public @ResponseBody Integer addNewUser (@RequestBody @Valid UserRequestModel userRequestModel) throws Exception {
        try {
            return userService.createUser(userRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @PutMapping(path="/{userId}")
    public @ResponseBody Integer updateUser (@PathVariable int userId, @RequestBody UserRequestModel userRequestModel) throws Exception {
        try {
            return userService.updateUser(userId, userRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @DeleteMapping(path="/{userId}")
    public @ResponseBody HttpStatus deleteUser (@PathVariable int userId) throws Exception {
        try {
           return userService.deleteUser(userId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping()
    public @ResponseBody Iterable<User> getAllUsers() throws Exception {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    @GetMapping(path="/{userId}")
    public @ResponseBody User getUserById(@PathVariable int userId) throws Exception {
        try {
            return userService.getUserById(userId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}