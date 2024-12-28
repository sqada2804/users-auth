package com.example.users_auth_api.services.impl;

import com.example.users_auth_api.commons.entities.UserModel;
import com.example.users_auth_api.dtos.UpdateInfoRequest;
import com.example.users_auth_api.dtos.UserRequest;
import com.example.users_auth_api.repository.UserRepository;
import com.example.users_auth_api.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository::findById).orElseThrow(() -> new RuntimeException("Error finding user by Id"));
    }

    @Override
    public void updateUser(UpdateInfoRequest userRequest, Long userId) {
        Optional.of(userId)
                .map(this::getUser)
                .map(existingUser -> updateFields(existingUser, userRequest))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Error couldn't update user"));
    }

    @Override
    public void deleteUser(Long userId) {
        Optional.of(userId)
                .map(this::getUser)
                .ifPresent(userRepository::delete);
    }

    private UserModel updateFields(UserModel existingUser, UpdateInfoRequest userRequest){
        existingUser.setName(userRequest.getName());
        existingUser.setEmail(userRequest.getEmail());
        return existingUser;

    }

    private UserModel mapToEntity(UserModel userRequest) {
        return UserModel.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
    }
}
