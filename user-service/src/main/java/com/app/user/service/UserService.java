package com.app.user.service;

import com.app.user.entity.User;
import com.app.user.rabbit.LogProducer;
import com.app.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LogProducer logProducer;

    public UserService(UserRepository userRepository, LogProducer logProducer) {
        this.userRepository = userRepository;
        this.logProducer = logProducer;
    }

    public List<User> getAllUsers() {
        logProducer.sendLog("Fetching all users.");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        logProducer.sendLog("Fetching user by ID: " + id);
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        logProducer.sendLog("User saved with ID: " + savedUser.getId());
        return savedUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        logProducer.sendLog("User deleted with ID: " + id);
    }
}
