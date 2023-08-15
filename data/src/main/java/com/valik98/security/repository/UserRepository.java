package com.valik98.security.repository;

import com.valik98.security.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<T> extends MongoRepository<User, T> {

    Optional<User> findByUsername(String username);
}
