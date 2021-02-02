package com.stone.challenge_1.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.challenge_1.app.models.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
