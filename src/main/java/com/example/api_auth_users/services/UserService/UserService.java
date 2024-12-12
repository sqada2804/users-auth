package com.example.api_auth_users.services.UserService;

import com.example.api_auth_users.common.models.UserModel;
import com.example.api_auth_users.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new RuntimeException("Error finding User: " + userId));
    }

    @Override
    public void updateUser(UserModel userRequest, Long userId) {
        Optional.of(userId).map(this::getUser)
                .map(existingUser -> updateFieldsUser(existingUser, userRequest))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Couldn´t update the User"));
    }

    @Override
    public void deleteUser(Long userId) {
        Optional.of(userId).map(this::getUser)
                .ifPresent(userRepository::delete);
    }

    private UserModel updateFieldsUser(UserModel existingUser, UserModel userRequest){
        existingUser.setName(userRequest.getName());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword());
        return existingUser;
    }

}
