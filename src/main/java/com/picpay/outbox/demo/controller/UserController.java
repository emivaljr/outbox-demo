package com.picpay.outbox.demo.controller;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping(path = "/user")
    public Response insertUser(){
        return null;
    }
    
}
