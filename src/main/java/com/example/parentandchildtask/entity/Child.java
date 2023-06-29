package com.example.parentandchildtask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Child {
    private int id;
    private String name;
    private Date birth_date;
}
