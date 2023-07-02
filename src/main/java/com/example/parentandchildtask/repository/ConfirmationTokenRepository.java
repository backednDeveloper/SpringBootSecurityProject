package com.example.parentandchildtask.repository;

import com.example.parentandchildtask.entity.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConfirmationTokenRepository {
    public interface confirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
        ConfirmationToken findByConfirmationToken(String confirmationToken);
        ConfirmationToken save(ConfirmationToken confirmationToken);
    }
}
