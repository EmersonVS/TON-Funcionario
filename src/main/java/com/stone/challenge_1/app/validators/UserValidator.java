package com.stone.challenge_1.app.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.challenge_1.app.models.entity.User;
import com.stone.challenge_1.app.models.repository.UserRepository;

@Service
public class UserValidator {

	@Autowired
	private UserRepository userRepository;

	public boolean isUserCreated(User requestedUser) {
		Optional<User> databaseUser = userRepository.findById(requestedUser.getUsername());
		if (databaseUser.isPresent()) {
			return true;
		}
		return false;
	}

}
