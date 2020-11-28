package com.sheriyans.s2custumauth.repository;

import com.sheriyans.s2custumauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String name);
}
