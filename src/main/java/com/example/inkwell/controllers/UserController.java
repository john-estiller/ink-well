package com.example.inkwell.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inkwell.dto.UserDto;
import com.example.inkwell.services.UserService;
import com.example.inkwell.utils.ResponseUtil;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers() {
        List<UserDto> users = this.userService.getUsers();
        System.out.println("Users: " + users);
        return ResponseUtil.response(true, users);
    }
}