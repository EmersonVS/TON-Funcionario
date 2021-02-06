package com.stone.challenge_1.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stone.challenge_1.app.controller.user.UserController;
import com.stone.challenge_1.app.controller.user.form.UserForm;
import com.stone.challenge_1.app.models.entity.User;
import com.stone.challenge_1.app.models.repository.UserRepository;
import com.stone.challenge_1.app.validators.UserValidator;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserValidator userValidator;

	private UserForm userForm = new UserForm();
	private String username = "username";
	private String password = "passowrd";
	private User user = new User(username, password);

	@Before
	public void before() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Testing code 200 GET - /register")
	public void getUserOK() {
		userForm.setPassword(password);
		userForm.setUsername(username);
		Mockito.when(userValidator.isUserCreated(username)).thenReturn(false);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		ResponseEntity<?> response = userController.CreateUser(userForm);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	@DisplayName("Testing code 404 GET - /register")
	public void getUserNOTFOUND() {
		userForm.setPassword(password);
		userForm.setUsername(username);
		Mockito.when(userValidator.isUserCreated(username)).thenReturn(true);
		ResponseEntity<?> response = userController.CreateUser(userForm);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
