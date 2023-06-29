package com.example.parentandchildtask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Parent {
    private int id;
    private String name;
    private String surname;
    private Date birth_date;
    private String job_name;


}