package com.picpay.outbox.demo.service;

import com.picpay.outbox.demo.repository.UserEventRepository;
import com.picpay.outbox.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserEventRepository userEventRepository;
    
    @Transactional
    public void insertUser(){
        userRepository.save(null);
        userEventRepository.save(null);
    }
}
