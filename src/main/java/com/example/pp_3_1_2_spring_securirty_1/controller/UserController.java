package com.example.pp_3_1_2_spring_securirty_1.controller;

import com.example.pp_3_1_2_spring_securirty_1.model.User;
import com.example.pp_3_1_2_spring_securirty_1.service.RoleService;
import com.example.pp_3_1_2_spring_securirty_1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@AllArgsConstructor

@Controller
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/user")
    public String getUser(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findUserByName(username);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRole());
        return "user-list";
    }
}
