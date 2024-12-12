package com.example.api_auth_users.repository;

import com.example.api_auth_users.common.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
}
