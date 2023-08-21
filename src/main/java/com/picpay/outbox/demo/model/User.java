package com.picpay.outbox.demo.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class User {

    private String name;

    private LocalDate birth;
}
