package com.example.parentandchildtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Parent")
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birth_date")
    private Date birth_date;
    @Column(name = "email")
    private String email;
    @Column(name = "email_id")
    private String email_id;

    public void setEnabled(boolean enabled) {
        if (enabled) {
            System.out.println("Profile is activated : " + this.email_id);
        } else {
            System.out.println("Profile is blocked : " + this.email_id);
        }
    }
}