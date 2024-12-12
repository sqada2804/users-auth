package com.example.api_auth_users.controllers;

import com.example.api_auth_users.common.models.UserModel;
import com.example.api_auth_users.services.UserService.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController{

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @Override
    public ResponseEntity<UserModel> getUser(Long UserId) {
        return ResponseEntity.ok(userService.getUser(UserId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> updateUser(UserModel userRequest, Long userId) {
        userService.updateUser(userRequest, userId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
