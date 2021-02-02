package com.stone.challenge_1.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.challenge_1.app.models.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}