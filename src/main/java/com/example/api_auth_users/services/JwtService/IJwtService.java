package com.example.api_auth_users.services.JwtService;

import com.example.api_auth_users.DTO.TokenResponse;
import io.jsonwebtoken.Claims;

public interface IJwtService {
    TokenResponse generateToken(Long userId);
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractUserId(String token);
}
