package com.example.users_auth_api.controllers;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.constants.ApiPathConstants;
import com.example.users_auth_api.dtos.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface IUserApi {
    @GetMapping(value = "/getUser/{userId}")
    ResponseEntity<UserModel> getUser(@PathVariable Long userId);

    @PutMapping(value = "/updateUser/{userId}")
    ResponseEntity<Void> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long userId);

    @DeleteMapping(value = "/delete/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);

}
