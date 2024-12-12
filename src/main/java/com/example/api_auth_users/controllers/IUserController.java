package com.example.api_auth_users.controllers;

import com.example.api_auth_users.common.constants.ApiPathConstants;
import com.example.api_auth_users.common.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface IUserController {

    @GetMapping(value = "/get/{userId}")
    ResponseEntity<UserModel> getUser (
        @PathVariable Long UserId
    );

    @PutMapping(value = "/update/{userId}")
    ResponseEntity<Void> updateUser(@RequestBody UserModel userRequest, @PathVariable Long userId);

    @DeleteMapping(value = "/delete/{userId}")
    ResponseEntity<Void> deleteUser (@PathVariable Long userId);
}
