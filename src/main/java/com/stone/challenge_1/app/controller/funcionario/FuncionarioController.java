package com.stone.challenge_1.app.controller.funcionario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.challenge_1.app.controller.funcionario.form.FuncionarioForm;
import com.stone.challenge_1.app.models.entity.Funcionario;
import com.stone.challenge_1.app.models.repository.FuncionarioRepository;
import com.stone.challenge_1.app.validators.FuncionarioValidator;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioValidator funcionarioValidator;

	@ApiOperation("Get funcionario info")
	@GetMapping("/{funcionarioID}")
	public ResponseEntity<?> GetFuncionario(@PathVariable Long funcionarioID) {
		if (funcionarioValidator.isFuncionarioCreated(funcionarioID)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Create funcionario")
	@PostMapping("/create")
	public ResponseEntity<?> CreateFuncionario(@RequestBody @Valid FuncionarioForm funcionarioForm) {
		Funcionario newFuncionario = funcionarioForm.MapAsFuncionarioEntity();
		funcionarioRepository.save(newFuncionario);
		return ResponseEntity.ok().build();			
	}

	@ApiOperation("Update funcionario info")
	@PutMapping("/{funcionarioID}")
	public ResponseEntity<?> UpdateFuncionario(@PathVariable Long funcionarioID) {
		return ResponseEntity.ok().build();
	}

	@ApiOperation("Delete funcionario")
	@DeleteMapping("/{funcionarioID}")
	public ResponseEntity<?> DeleteFuncionario(@PathVariable Long funcionarioID) {
		return ResponseEntity.ok().build();
	}

}
