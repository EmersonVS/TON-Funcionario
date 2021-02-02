package com.stone.challenge_1.app.controller.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.challenge_1.app.models.repository.FuncionarioRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@ApiOperation("Get funcionario info")
	@GetMapping("/{id}")
	public ResponseEntity<?> GetFuncionario() {
		return ResponseEntity.ok().build();
	}

	@ApiOperation("Create funcionario")
	@PostMapping("/create")
	public ResponseEntity<?> CreateFuncionario() {
		return ResponseEntity.ok().build();
	}

	@ApiOperation("Update funcionario info")
	@PutMapping("/{id}")
	public ResponseEntity<?> UpdateFuncionario() {
		return ResponseEntity.ok().build();
	}

	@ApiOperation("Delete funcionario")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteFuncionario() {
		return ResponseEntity.ok().build();
	}

}
