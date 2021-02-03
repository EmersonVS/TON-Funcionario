package com.stone.challenge_1.app.controller.funcionario.DTO;

import com.stone.challenge_1.app.models.entity.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private String cargo;
	private Integer idade;
	
	
	public FuncionarioDTO(Funcionario newFuncionario) {
		this.id = newFuncionario.getFuncionarioId();
		this.nome = newFuncionario.getNome();
		this.cargo = newFuncionario.getCargo();
		this.idade = newFuncionario.getIdade();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public Integer getIdade() {
		return idade;
	}

}
