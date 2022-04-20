package com.example.pp_3_1_2_spring_securirty_1.model;

import com.example.pp_3_1_2_spring_securirty_1.repository.RoleRepository;
import com.example.pp_3_1_2_spring_securirty_1.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor

@Getter

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name.toUpperCase();
    }

}
