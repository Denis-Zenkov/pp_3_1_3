package com.example.pp_3_1_2_spring_securirty_1.repository;

import com.example.pp_3_1_2_spring_securirty_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}
