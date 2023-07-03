package com.example.parentandchildtask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ConfirmationToken")
public class ConfirmationTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "confirmationToken")
    private String confirmationToken;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "token_id")
    private Long token_id;
    @OneToOne(targetEntity = ParentEntity.class , fetch = FetchType.EAGER)
    @JoinColumn(nullable = false , name = "id")
    private ParentEntity parent;

    public ConfirmationTokenEntity(ParentEntity parent) {
        this.parent = parent;
        createDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}
