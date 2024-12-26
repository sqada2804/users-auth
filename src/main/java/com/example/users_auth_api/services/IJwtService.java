package com.example.users_auth_api.services;

import com.example.users_auth_api.dtos.TokenResponse;
import io.jsonwebtoken.Claims;

public interface IJwtService {
    TokenResponse generateToken(Long userId);
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractedUserId(String token);

}
