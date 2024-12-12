package com.example.api_auth_users.services.AuthService;

import com.example.api_auth_users.DTO.TokenResponse;
import com.example.api_auth_users.common.models.UserModel;

public interface IAuthService {
    TokenResponse createUser(UserModel userRequest);
    UserModel mapToEntity(UserModel userRequest);
}
