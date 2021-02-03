package com.stone.challenge_1.config.handler.DTO;

public class FormErrorDTO {
	
	private String field;
	private String erro;
	
	public FormErrorDTO(String field, String erro) {
		this.field = field;
		this.erro = erro;
	}
	
	public String getField() {
		return field;
	}
	public String getErro() {
		return erro;
	}
	
}
