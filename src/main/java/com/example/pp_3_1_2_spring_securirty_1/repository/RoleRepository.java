package com.example.pp_3_1_2_spring_securirty_1.repository;

import com.example.pp_3_1_2_spring_securirty_1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
