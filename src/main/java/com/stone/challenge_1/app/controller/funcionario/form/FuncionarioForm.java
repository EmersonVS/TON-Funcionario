package com.stone.challenge_1.app.controller.funcionario.form;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

import com.stone.challenge_1.app.models.entity.Funcionario;

public class FuncionarioForm {

	@NotNull(message="Nome não pode ser nulo")
	@NotEmpty(message="Nome não pode ser vazio")
	private String nome;
	@NotNull(message="Cargo não pode ser nulo")
	@NotEmpty(message="Cargo não pode ser vazio")
	private String cargo;
	@NotNull(message="Idade não pode ser nulo")
	private Integer idade;

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public Integer getIdade() {
		return idade;
	}
	
	public Funcionario MapAsFuncionarioEntity() {
		Funcionario newFuncionario = new Funcionario(this.nome, this.cargo, this.idade);
		return newFuncionario;
	}

}
