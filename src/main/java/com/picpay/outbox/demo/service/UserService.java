package com.picpay.outbox.demo.service;

import com.picpay.outbox.demo.model.UserEvent;
import com.picpay.outbox.demo.model.entity.UserEntity;
import com.picpay.outbox.demo.model.entity.UserEventEntity;
import com.picpay.outbox.demo.producer.UserMessageProducer;
import com.picpay.outbox.demo.repository.UserEventRepository;
import com.picpay.outbox.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserEventRepository userEventRepository;

    private final UserMessageProducer userMessageProducer;
    
    @Transactional
    public void processEvent(UserEvent event){
        log.info("Saving User");
        //Save User
        var userEntity = UserEntity.fromModel(event.getUser());
        userRepository.save(userEntity);
        log.info("Saving Event");
        //Save Event
        var userEventEntity = UserEventEntity.newEventEntity(userEntity);
        userEventRepository.save(userEventEntity);
    }

    @Transactional
    public void sendMessages() {
        var events = userEventRepository
                .findAll();
        if(!events.iterator().hasNext()){
            log.info("No messages to process, exiting now!");
        }
            events
                .forEach(userEventEntity -> {
                    log.info("Sending message");
                    userMessageProducer.sendEvent(userEventEntity.toDomain());
                    userEventRepository.delete(userEventEntity);
                });
    }
}
