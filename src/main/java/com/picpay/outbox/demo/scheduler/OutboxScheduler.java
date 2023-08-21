package com.picpay.outbox.demo.scheduler;

import com.picpay.outbox.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
@Slf4j
public class OutboxScheduler {

    private final UserService userService;

    @Scheduled(fixedRate = 120,timeUnit = TimeUnit.SECONDS)
    public void sendMessages(){
      log.info("Starting Outbox Process");
        userService.sendMessages();
    }

}
