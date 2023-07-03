package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Parentrepository2 extends JpaRepository<ParentEntity, Long> {

    Optional<ParentEntity> findByEmail(String email_id);
}
