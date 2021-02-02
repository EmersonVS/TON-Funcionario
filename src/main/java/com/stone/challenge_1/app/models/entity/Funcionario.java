package com.stone.challenge_1.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private Integer idade;
	private String nome;
	private String cargo;

	public Long getAccountId() {
		return accountId;
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

}
