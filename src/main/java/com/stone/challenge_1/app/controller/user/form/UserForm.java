package com.stone.challenge_1.app.controller.user.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.stone.challenge_1.app.models.entity.User;

public class UserForm {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public User mapAsUser() {
		User newUser = new User(this.username, this.password);
		return newUser;
	}
	
	public UsernamePasswordAuthenticationToken mapAsUsernamePasswordAuthenticationToken() {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(this.username, this.password);
		return usernamePasswordAuthenticationToken;
	}

}
