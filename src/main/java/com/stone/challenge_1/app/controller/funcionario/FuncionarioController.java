package com.stone.challenge_1.app.controller.funcionario;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stone.challenge_1.app.controller.funcionario.DTO.FuncionarioDTO;
import com.stone.challenge_1.app.controller.funcionario.form.FuncionarioForm;
import com.stone.challenge_1.app.controller.funcionario.form.validation.PostFuncionarioValidation;
import com.stone.challenge_1.app.controller.funcionario.form.validation.PutFuncionarioValidation;
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
	public ResponseEntity<FuncionarioDTO> GetFuncionario(@PathVariable Long funcionarioID) {
		if (funcionarioValidator.isFuncionarioCreated(funcionarioID)) {
			Funcionario databaseFuncionario = funcionarioRepository.getOne(funcionarioID);
			return ResponseEntity.ok().body(new FuncionarioDTO(databaseFuncionario));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Create funcionario")
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<FuncionarioDTO> CreateFuncionario(
			@RequestBody @Validated(PostFuncionarioValidation.class) FuncionarioForm funcionarioForm, UriComponentsBuilder uriBuilder) {
		Funcionario newFuncionario = funcionarioForm.MapAsFuncionarioEntity();
		funcionarioRepository.save(newFuncionario);
		URI newUserURL = uriBuilder.path("/funcionario/{id}").buildAndExpand(newFuncionario.getFuncionarioId()).toUri();
		return ResponseEntity.created(newUserURL).body(new FuncionarioDTO(newFuncionario));
	}

	@ApiOperation("Update funcionario info")
	@PutMapping("/{funcionarioID}")
	@Transactional
	public ResponseEntity<FuncionarioDTO> UpdateFuncionario(@PathVariable Long funcionarioID,
			@RequestBody @Validated(PutFuncionarioValidation.class) FuncionarioForm funcionarioForm) {
		if (funcionarioValidator.isFuncionarioCreated(funcionarioID)) {
			Funcionario databaseFuncionario = funcionarioRepository.getOne(funcionarioID);
			Funcionario updatedFuncionario = funcionarioForm.UpdateFuncionario(databaseFuncionario);
			funcionarioRepository.save(updatedFuncionario);
			return ResponseEntity.accepted().body(new FuncionarioDTO(updatedFuncionario));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation("Delete funcionario")
	@DeleteMapping("/{funcionarioID}")
	@Transactional
	public ResponseEntity<FuncionarioDTO> DeleteFuncionario(@PathVariable Long funcionarioID) {
		if (funcionarioValidator.isFuncionarioCreated(funcionarioID)) {
			Funcionario databaseFuncionario = funcionarioRepository.getOne(funcionarioID);
			funcionarioRepository.delete(databaseFuncionario);
			return ResponseEntity.accepted().body(new FuncionarioDTO(databaseFuncionario));
		}
		return ResponseEntity.notFound().build();
	}

}
