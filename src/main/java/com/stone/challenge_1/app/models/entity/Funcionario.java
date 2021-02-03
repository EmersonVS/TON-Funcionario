package com.stone.challenge_1.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long funcionarioId;
	private String nome;
	private String cargo;
	private Integer idade;

	@Deprecated
	public Funcionario() {

	}

	public Funcionario(String nome, String cargo, Integer idade) {
		this.idade = idade;
		this.nome = nome;
		this.cargo = cargo;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
