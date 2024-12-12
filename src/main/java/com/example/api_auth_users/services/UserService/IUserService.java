package com.example.api_auth_users.services.UserService;

import com.example.api_auth_users.common.models.UserModel;

public interface IUserService {
    UserModel getUser(Long userId);
    void updateUser(UserModel userRequest, Long userId);
    void deleteUser(Long userId);
}
