package com.example.parentandchildtask.config;

import com.example.parentandchildtask.entity.ConfirmationTokenEntity;
import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class ConfirmationTokenConfig {
    @Bean
    public ConfirmationTokenRepository confirmationTokenRepository2() {
        return new ConfirmationTokenRepository() {
            @Override
            public <S extends ConfirmationTokenEntity> S save(S entity) {
                return null;
            }

            @Override
            public <S extends ConfirmationTokenEntity> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<ConfirmationTokenEntity> findById(String s) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(String s) {
                return false;
            }

            @Override
            public Iterable<ConfirmationTokenEntity> findAll() {
                return null;
            }

            @Override
            public Iterable<ConfirmationTokenEntity> findAllById(Iterable<String> strings) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(String s) {

            }

            @Override
            public void delete(ConfirmationTokenEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends String> strings) {

            }

            @Override
            public void deleteAll(Iterable<? extends ConfirmationTokenEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public ConfirmationTokenEntity findByConfirmationToken(String confirmationToken) {
                return null;
            }
        };
    }
}