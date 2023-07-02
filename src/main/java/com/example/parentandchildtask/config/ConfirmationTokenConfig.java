package com.example.parentandchildtask.config;

import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmationTokenConfig {
    @Bean
    public ConfirmationTokenRepository confirmationTokenRepository2() {
        return new ConfirmationTokenRepository();
    }
}