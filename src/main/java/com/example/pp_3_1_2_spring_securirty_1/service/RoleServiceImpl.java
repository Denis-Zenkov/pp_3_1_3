package com.example.pp_3_1_2_spring_securirty_1.service;

import com.example.pp_3_1_2_spring_securirty_1.model.Role;
import com.example.pp_3_1_2_spring_securirty_1.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
