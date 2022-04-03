package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()) throw new IllegalStateException("Username already exist");
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id: " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String username, String lastName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id: " + userId + "does not exist"));
        if (username != null &&
                username.length() > 0 &&
                !Objects.equals(user.getUsername(), username)){
            user.setUsername(username);
        }
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(user.getLastName(), lastName)){
            Optional<User> userOptional = userRepository.findUserByUsername(lastName);
            if (userOptional.isPresent()) throw new IllegalStateException("Username already exist");
            user.setLastName(lastName);
        }
    }
}
