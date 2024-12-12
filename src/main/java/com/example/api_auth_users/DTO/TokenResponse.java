package com.example.api_auth_users.DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenResponse {
    public String accessToken;
}
