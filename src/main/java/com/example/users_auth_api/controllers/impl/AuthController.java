package com.example.users_auth_api.controllers.impl;

import com.example.users_auth_api.controllers.IAuthApi;
import com.example.users_auth_api.dtos.LoginRequest;
import com.example.users_auth_api.dtos.TokenResponse;
import com.example.users_auth_api.dtos.UserRequest;
import com.example.users_auth_api.services.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements IAuthApi {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<TokenResponse> loginUser(LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.loginUser(loginRequest));
    }
}
