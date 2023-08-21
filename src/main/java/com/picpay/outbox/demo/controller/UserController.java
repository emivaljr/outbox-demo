package com.picpay.outbox.demo.controller;

import com.picpay.outbox.demo.model.User;
import com.picpay.outbox.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService service;

    @PostMapping(path = "/user")
    public Response insertUser(@RequestBody User user){
        service.insertUser(user);
        return null;
    }
    
}
