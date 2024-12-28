package com.example.users_auth_api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
