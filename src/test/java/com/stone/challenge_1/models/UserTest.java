package com.stone.challenge_1.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.stone.challenge_1.app.models.entity.User;

@SpringBootTest
public class UserTest {

	private String usernameTeste = "UsernameTeste";
	private String passwordTeste = "PasswordTeste";

	@Test
	@DisplayName("Testing User empty constructor")
	void TestingFuncionarioEmptyConstructor() {
		@SuppressWarnings("deprecation")
		User newUser = new User();
		assertEquals(User.class, newUser.getClass());
		assertNotEquals(null, newUser);
	}

	@Test
	@DisplayName("Testing User constructor")
	void TestingFuncionarioConstructor() {
		User newUser = new User(usernameTeste, passwordTeste);
		assertEquals(User.class, newUser.getClass());
		assertNotEquals(null, newUser);
	}

	@Test
	@DisplayName("Testing User Getter")
	void TestingFuncionarioGetters() {
		User newUser = new User(usernameTeste, passwordTeste);
		assertEquals(usernameTeste, newUser.getUsername());
		assertNotEquals(passwordTeste, newUser.getPassword());
	}

	@Test
	@DisplayName("Testing User Setter")
	void TestingFuncionarioSetters() {
		User newUser = new User(usernameTeste, passwordTeste);
		String passwordTeste2 = "PasswordTeste2";
		assertNotEquals(passwordTeste2, newUser.getPassword());
	}
}
