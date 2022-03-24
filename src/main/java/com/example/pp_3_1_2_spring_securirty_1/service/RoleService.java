package com.example.pp_3_1_2_spring_securirty_1.service;


import com.example.pp_3_1_2_spring_securirty_1.model.Role;

public interface RoleService {
    void deleteById(Long id);
    Role findByName(String name);
}
