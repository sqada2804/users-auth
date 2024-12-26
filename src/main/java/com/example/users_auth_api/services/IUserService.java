package com.example.users_auth_api.services;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.dtos.UserRequest;

public interface IUserService {
    UserModel getUser(Long userId);
    void updateUser(UserRequest userRequest, Long userId);
    void deleteUser(Long id);
}
