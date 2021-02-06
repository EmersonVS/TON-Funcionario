package com.stone.challenge_1.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.stone.challenge_1.app.controller.funcionario.FuncionarioController;
import com.stone.challenge_1.app.controller.funcionario.DTO.FuncionarioDTO;
import com.stone.challenge_1.app.models.entity.Funcionario;
import com.stone.challenge_1.app.models.repository.FuncionarioRepository;
import com.stone.challenge_1.app.validators.FuncionarioValidator;

@SpringBootTest
public class FuncionarioControllerTest {


	@InjectMocks
	private FuncionarioController funcionarioController;
	
	@Mock
	private FuncionarioValidator funcionarioValidator;
	
	@Mock
	private FuncionarioRepository funcionarioRepository;
	
	Funcionario newFuncionario = new Funcionario("NomeTeste", "CargoTeste", 19);
	Funcionario newFuncionario2 = new Funcionario("NomeTeste2", "CargoTeste2", 19);
	private Long funcionarioId = 1L;
	private Long funcionarioId2 = 2L;

	@Before
	public void before() {
		newFuncionario.setFuncionarioId(funcionarioId);
		newFuncionario2.setFuncionarioId(funcionarioId2);
		MockitoAnnotations.openMocks(this);;
	}

	@Test
	@DisplayName("Testing code 200 GET - /{funcionarioId}")
	public void getFuncionarioOK() {
		Mockito.when(funcionarioRepository.getOne(funcionarioId)).thenReturn(newFuncionario);
		Mockito.when(funcionarioValidator.isFuncionarioCreated(funcionarioId)).thenReturn(true);
		ResponseEntity<FuncionarioDTO> response = funcionarioController.GetFuncionario(funcionarioId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(newFuncionario.getNome(), response.getBody().getNome());
		assertEquals(newFuncionario.getCargo(), response.getBody().getCargo());
		assertEquals(newFuncionario.getIdade(), response.getBody().getIdade());
		assertEquals(newFuncionario.getFuncionarioId(), response.getBody().getId());
	}
	
	@Test
	@DisplayName("Testing code 404 GET - /{funcionarioId}")
	public void getFuncionarioNOTFOUND() {
		Mockito.when(funcionarioRepository.getOne(funcionarioId)).thenReturn(newFuncionario);
		Mockito.when(funcionarioValidator.isFuncionarioCreated(funcionarioId)).thenReturn(false);
		ResponseEntity<FuncionarioDTO> response = funcionarioController.GetFuncionario(funcionarioId);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(null, response.getBody());
	}
	
	@Test
	@DisplayName("Testing code 200 GET - /")
	public void getFuncionariosOK() {
		Mockito.when(funcionarioRepository.findAll()).thenReturn(List.of(newFuncionario, newFuncionario2));
		Mockito.when(funcionarioValidator.isAnyFuncionarioCreated()).thenReturn(true);
		ResponseEntity<List<FuncionarioDTO>> response = funcionarioController.GetFuncionarios();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(newFuncionario.getNome(), response.getBody().get(0).getNome());
		assertEquals(newFuncionario.getCargo(), response.getBody().get(0).getCargo());
		assertEquals(newFuncionario.getIdade(), response.getBody().get(0).getIdade());
		assertEquals(newFuncionario.getFuncionarioId(), response.getBody().get(0).getId());
		assertEquals(newFuncionario2.getNome(), response.getBody().get(1).getNome());
		assertEquals(newFuncionario2.getCargo(), response.getBody().get(1).getCargo());
		assertEquals(newFuncionario2.getIdade(), response.getBody().get(1).getIdade());
		assertEquals(newFuncionario2.getFuncionarioId(), response.getBody().get(1).getId());
	}
	
	@Test
	@DisplayName("Testing code 404 GET - /")
	public void getFuncionariosNOTFOUND() {
		Mockito.when(funcionarioValidator.isAnyFuncionarioCreated()).thenReturn(false);
		ResponseEntity<List<FuncionarioDTO>> response = funcionarioController.GetFuncionarios();
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(null, response.getBody());
	}

}
