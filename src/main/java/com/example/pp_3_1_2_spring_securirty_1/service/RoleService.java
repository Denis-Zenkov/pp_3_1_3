package com.example.pp_3_1_2_spring_securirty_1.service;


import com.example.pp_3_1_2_spring_securirty_1.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> getAllRole();
}
