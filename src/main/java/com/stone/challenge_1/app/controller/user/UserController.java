package com.stone.challenge_1.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.challenge_1.app.controller.user.DTO.TokenDTO;
import com.stone.challenge_1.app.controller.user.form.UserForm;
import com.stone.challenge_1.app.models.entity.User;
import com.stone.challenge_1.app.models.repository.UserRepository;
import com.stone.challenge_1.app.validators.UserValidator;
import com.stone.challenge_1.config.secutiry.token.TokenService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserValidator userValidator;

	@PostMapping("/register")
	public ResponseEntity<?> CreateUser(@RequestBody UserForm userForm) {
		User newUser = userForm.mapAsUser();
		if(userValidator.isUserCreated(newUser)) {
			return ResponseEntity.status(400).build();
		}
		userRepository.save(newUser);
		return ResponseEntity.status(201).build();
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> GenerateToken(@RequestBody UserForm userForm) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = userForm.mapAsUsernamePasswordAuthenticationToken();
		try {
			Authentication authenticatedUser = authManager.authenticate(usernamePasswordAuthenticationToken);
			String newToken = tokenService.genToken(authenticatedUser);
			return ResponseEntity.status(200).body(new TokenDTO(newToken));			
		} catch (AuthenticationException error) {
			System.out.println(error);
			return ResponseEntity.badRequest().build();
		}
	}
	
}
