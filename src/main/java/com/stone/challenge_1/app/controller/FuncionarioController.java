package com.stone.challenge_1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/")
	public ResponseEntity<?> GetFuncionario() {
		return null;
	}

	@ApiOperation("Create funcionario")
	@PostMapping("/")
	public ResponseEntity<?> CreateFuncionario() {
		return null;
	}

	@ApiOperation("Update funcionario info")
	@PutMapping("/")
	public ResponseEntity<?> UpdateFuncionario() {
		return null;
	}

	@ApiOperation("Delte funcionario")
	@DeleteMapping("/")
	public ResponseEntity<?> DeleteFuncionario() {
		return null;
		
	}

}
