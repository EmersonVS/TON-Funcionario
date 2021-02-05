package com.stone.challenge_1.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.stone.challenge_1.app.models.entity.Funcionario;

@SpringBootTest
public class FuncionarioTest {

	private String nomeTeste = "NomeTeste";
	private String cargoTeste = "CargoTeste";
	private Integer idadeTeste = 21;
	
	@Test
	@DisplayName("Testing Funcionario empty constructor")
	void TestingFuncionarioEmptyConstructor() {
		@SuppressWarnings("deprecation")
		Funcionario newFuncionario = new Funcionario();
		assertEquals(newFuncionario.getClass(), Funcionario.class);
		assertNotEquals(newFuncionario, null);
	}
	
	@Test
	@DisplayName("Testing Funcionario constructor")
	void TestingFuncionarioConstructor() {
		Funcionario newFuncionario = new Funcionario(nomeTeste, cargoTeste, idadeTeste);
		assertEquals(newFuncionario.getClass(), Funcionario.class);
		assertNotEquals(newFuncionario, null);
	}
	
	@Test
	@DisplayName("Testing Funcionario Getter")
	void TestingFuncionarioGetters() {
		Funcionario newFuncionario = new Funcionario(nomeTeste, cargoTeste, idadeTeste);
		assertEquals(newFuncionario.getNome(), nomeTeste);
		assertEquals(newFuncionario.getCargo(), cargoTeste);
		assertEquals(newFuncionario.getIdade(), idadeTeste);
		assertEquals(newFuncionario.getFuncionarioId(), null);
	}
	
	@Test
	@DisplayName("Testing Funcionario Setter")
	void TestingFuncionarioSetters() {
		Funcionario newFuncionario = new Funcionario(nomeTeste, cargoTeste, idadeTeste);
		String nomeTeste2 = "NomeTeste2";
		String cargoTeste2 = "CargoTeste2";
		Integer idadeTeste2 = 212;
		newFuncionario.setNome(nomeTeste2);
		newFuncionario.setCargo(cargoTeste2);
		newFuncionario.setIdade(idadeTeste2);
		assertEquals(newFuncionario.getNome(), nomeTeste2);
		assertEquals(newFuncionario.getCargo(), cargoTeste2);
		assertEquals(newFuncionario.getIdade(), idadeTeste2);
	}
}
