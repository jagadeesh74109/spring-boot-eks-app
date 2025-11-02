package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with id: {}", id);
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        logger.info("Creating new user: {}", user.getEmail());
        if (userRepository.existsByEmail(user.getEmail())) {
            logger.error("User already exists with email: {}", user.getEmail());
            throw new RuntimeException("User already exists with email: " + user.getEmail());
        }
        User savedUser = userRepository.save(user);
        logger.info("User created successfully with id: {}", savedUser.getId());
        return savedUser;
    }

    public User updateUser(Long id, User userDetails) {
        logger.info("Updating user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with id: {}", id);
                    return new RuntimeException("User not found with id: " + id);
                });

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        User updatedUser = userRepository.save(user);
        logger.info("User updated successfully with id: {}", updatedUser.getId());
        return updatedUser;
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("User not found with id: {}", id);
                    return new RuntimeException("User not found with id: " + id);
                });
        userRepository.delete(user);
        logger.info("User deleted successfully with id: {}", id);
    }
}
