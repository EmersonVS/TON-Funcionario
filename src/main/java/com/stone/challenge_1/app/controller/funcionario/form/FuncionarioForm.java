package com.stone.challenge_1.app.controller.funcionario.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stone.challenge_1.app.controller.funcionario.form.validation.PostFuncionarioValidation;
import com.stone.challenge_1.app.controller.funcionario.form.validation.PutFuncionarioValidation;
import com.stone.challenge_1.app.models.entity.Funcionario;

public class FuncionarioForm {

	@NotNull(message="Nome não pode ser nulo", groups = PostFuncionarioValidation.class)
	@NotEmpty(message="Nome não pode ser vazio", groups = PostFuncionarioValidation.class)
	@Size(min=5, groups = {PostFuncionarioValidation.class, PutFuncionarioValidation.class})
	private String nome;
	@NotNull(message="Cargo não pode ser nulo", groups = PostFuncionarioValidation.class)
	@NotEmpty(message="Cargo não pode ser vazio", groups = PostFuncionarioValidation.class)
	private String cargo;
	@NotNull(message="Idade não pode ser nulo", groups = PostFuncionarioValidation.class)
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
	
	public Funcionario UpdateFuncionario(Funcionario databaseFuncionario) {
		Funcionario updatedFuncionario = databaseFuncionario;
		if (this.nome != null) {
			updatedFuncionario.setNome(this.nome);
		}
		if (this.cargo != null) {
			updatedFuncionario.setCargo(this.cargo);
		}
		if (this.idade != null) {
			updatedFuncionario.setIdade(this.idade);
		}
		return updatedFuncionario;
	}

}
