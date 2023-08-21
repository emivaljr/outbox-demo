package com.picpay.outbox.demo.service;

import com.picpay.outbox.demo.model.User;
import com.picpay.outbox.demo.model.UserEvent;
import com.picpay.outbox.demo.model.entity.UserEntity;
import com.picpay.outbox.demo.model.entity.UserEventEntity;
import com.picpay.outbox.demo.producer.UserMessageProducer;
import com.picpay.outbox.demo.repository.UserEventRepository;
import com.picpay.outbox.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.Message;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserEventRepository userEventRepository;

    private final UserMessageProducer userMessageProducer;
    
    @Transactional
    public void insertUser(User user){
        //Save User
        var userEntity = UserEntity.fromModel(user);
        userRepository.save(userEntity);
        //Save Event
        var userEventEntity = UserEventEntity.newEventEntity(userEntity);
        userEventRepository.save(userEventEntity);
        //Send Event
        userMessageProducer.sendEvent(new UserEvent(userEventEntity.getId(),userEventEntity.getType(),user));
    }
}
