package com.example.pp_3_1_2_spring_securirty_1.controller;

import com.example.pp_3_1_2_spring_securirty_1.dto.UserDto;
import com.example.pp_3_1_2_spring_securirty_1.model.Role;
import com.example.pp_3_1_2_spring_securirty_1.model.User;
import com.example.pp_3_1_2_spring_securirty_1.service.RoleService;
import com.example.pp_3_1_2_spring_securirty_1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor

@Controller
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model){
        User user = userService.getUserById(id);
        List<String> strRoles = new ArrayList<>();

        for(Role role: user.getRoles()){
            strRoles.add(role.getAuthority());
        }

        UserDto userDto = new UserDto(user.getId(), user.getName(),
                user.getSurname(), user.getEmail(), user.getPassword(), strRoles);


        model.addAttribute("user", userDto);
        return "user-update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDto userDto){
        Set<Role> roles = new HashSet<>();

        for(String role: userDto.getRoles()){
            Role userRole = roleService.findByName(role);
            if(userRole == null){
                roles.add(new Role(role));
            }
            else {
                roles.add(userRole);
            }
        }

        User user = new User(userDto.getId(), userDto.getName(), userDto.getSurname(),
                userDto.getEmail(), userDto.getPassword(), roles);
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
