package com.stone.challenge_1.app.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.challenge_1.app.models.entity.Funcionario;
import com.stone.challenge_1.app.models.repository.FuncionarioRepository;

@Service
public class FuncionarioValidator {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public boolean isFuncionarioCreated(Long funcionarioID) {
		Optional<Funcionario> databaseFuncionario = funcionarioRepository.findById(funcionarioID);
		if (databaseFuncionario.isPresent()) {
			return true;
		}
		return false;
	}
	
}
