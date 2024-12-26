package com.example.users_auth_api.services.impl;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.dtos.TokenResponse;
import com.example.users_auth_api.dtos.UserRequest;
import com.example.users_auth_api.repository.UserRepository;
import com.example.users_auth_api.services.IAuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtServiceImpl jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));

    }

    private UserModel mapToEntity( UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .role("USER")
                .build();
    }
}
