//package com.example.parentandchildtask.config;
//
//import com.example.parentandchildtask.entity.ConfirmationToken;
//import com.example.parentandchildtask.repository.ConfirmationTokenRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Optional;
//
//@Configuration
//public class ConfirmationTokenConfig {
//    @Bean
//    public ConfirmationTokenRepository confirmationTokenRepository2() {
//        return new ConfirmationTokenRepository() {
//            @Override
//            public <S extends ConfirmationToken> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends ConfirmationToken> Iterable<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public Optional<ConfirmationToken> findById(String s) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(String s) {
//                return false;
//            }
//
//            @Override
//            public Iterable<ConfirmationToken> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<ConfirmationToken> findAllById(Iterable<String> strings) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(String s) {
//
//            }
//
//            @Override
//            public void delete(ConfirmationToken entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends String> strings) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends ConfirmationToken> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public ConfirmationToken findByConfirmationToken(String confirmationToken) {
//                return null;
//            }
//        };
//    }
//}