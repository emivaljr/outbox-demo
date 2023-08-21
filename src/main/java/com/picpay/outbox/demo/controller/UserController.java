package com.picpay.outbox.demo.controller;

import com.picpay.outbox.demo.model.EventType;
import com.picpay.outbox.demo.model.User;
import com.picpay.outbox.demo.model.UserEvent;
import com.picpay.outbox.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService service;

    @PostMapping(path = "/user")
    public Response insertUser(@RequestBody User user){
        UserEvent event = new UserEvent(UUID.randomUUID(), EventType.USER_WAS_CREATED,user);
        service.processEvent(event);
        return null;
    }
    
}
