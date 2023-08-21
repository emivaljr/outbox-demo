package com.picpay.outbox.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class User {

    private String name;

    private LocalDate birth;
}
