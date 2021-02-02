package com.stone.challenge_1.app.controller.user.DTO;


public class TokenDTO {
	
	public String expValue = "3600";
	public String type = "Bearer";
	public String token;
	
	public TokenDTO(String token) {
		this.token = token;
	}

}
