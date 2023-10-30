package com.company.Use.Open.Api.service;

import com.company.Use.Open.Api.entity.User;
import com.company.Use.Open.Api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User insertUser(User user) {
        User savedUser = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        userRepository.save(savedUser);
        return savedUser;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(" Not found User in id: "+ id));
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    public void deleteUserById(Long id ) {
//        User deletedUser = userRepository.findById(id).get();
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException(" User not found with id" + id));
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
       return updatedUser;
    }
}
