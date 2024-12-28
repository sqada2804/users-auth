package com.example.users_auth_api.controllers;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.constants.ApiPathConstants;
import com.example.users_auth_api.dtos.UpdateInfoRequest;
import com.example.users_auth_api.dtos.UserRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface IUserApi {
    @GetMapping(value = "/getUser/{userId}")
    ResponseEntity<UserModel> getUser(@RequestHeader("X-User-Id") Long userId);

    @PutMapping(value = "/updateUser/{userId}")
    ResponseEntity<Void> updateUser(@RequestBody UpdateInfoRequest userRequest, @RequestHeader("X-User-Id") Long userId);

    @DeleteMapping(value = "/delete/{userId}")
    ResponseEntity<Void> deleteUser(@RequestHeader("X-User-Id") Long userId);
}
