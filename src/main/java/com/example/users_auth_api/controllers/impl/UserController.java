package com.example.users_auth_api.controllers.impl;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.controllers.IUserApi;
import com.example.users_auth_api.dtos.UserRequest;
import com.example.users_auth_api.services.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserApi {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserModel> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<Void> updateUser(UserRequest userRequest, Long userId) {
        userService.updateUser(userRequest, userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
