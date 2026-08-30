package com.truthlens.service;

import com.truthlens.dto.RegisterRequest;
import com.truthlens.entity.User;
import com.truthlens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.truthlens.dto.LoginRequest;

import com.truthlens.dto.LoginResponse;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists!";
        }

        // Create User object
        User user = new User();

        // Copy data from RegisterRequest to User
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // Save user in MySQL
        userRepository.save(user);

        return "User Registered Successfully";
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return new LoginResponse(false, "User not found!", null, null);
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(false, "Invalid Password!", null, null);
        }

        return new LoginResponse(true, "Login Successful", user.getName(), user.getEmail());
    }
}

