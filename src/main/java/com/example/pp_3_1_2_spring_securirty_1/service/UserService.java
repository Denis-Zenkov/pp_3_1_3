package com.example.pp_3_1_2_spring_securirty_1.service;



import com.example.pp_3_1_2_spring_securirty_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteById(Long id);
    User findUserByName(String name);
}
