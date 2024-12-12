package com.example.api_auth_users.services.AuthService;

import com.example.api_auth_users.DTO.TokenResponse;
import com.example.api_auth_users.common.models.UserModel;
import com.example.api_auth_users.repository.IUserRepository;
import com.example.api_auth_users.services.JwtService.IJwtService;
import org.apache.catalina.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AuthService implements IAuthService{
    private final IUserRepository userRepository;
    private final IJwtService jwtService;

    public AuthService(IUserRepository userRepository, IJwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserModel userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public UserModel mapToEntity(UserModel userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role("USER")
                .build();
    }
}
