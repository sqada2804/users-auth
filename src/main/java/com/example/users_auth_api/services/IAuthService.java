package com.example.users_auth_api.services;


import com.example.users_auth_api.dtos.TokenResponse;
import com.example.users_auth_api.dtos.UserRequest;

public interface IAuthService {
    TokenResponse createUser(UserRequest userRequest);
}
