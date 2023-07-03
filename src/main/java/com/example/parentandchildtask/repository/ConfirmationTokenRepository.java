package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.ConfirmationTokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationTokenEntity, String> {
    ConfirmationTokenEntity findByConfirmationToken(String confirmationToken);
}

