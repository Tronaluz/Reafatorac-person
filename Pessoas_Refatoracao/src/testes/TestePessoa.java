package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import codigo.Pessoa;

class TestePessoa {

	@Test
	void testExisteComCpfInvalido() {
		pessoa.setCadPessFis("321");
		pessoa.setN("Lucas");
		pessoa.setS("Oliveira");
		assertTrue(pessoa.existe());
	}

	@Test
	void testExisteComNomeInvalido() {
		pessoa.setCadPessFis("32187599955");
		pessoa.setN("Lu");
		pessoa.setS("Oliveira");
		assertFalse(pessoa.existe());
	}

	@Test
	void testExisteComSobrenomeInvalido() {
		pessoa.setCadPessFis("48768975455");
		pessoa.setN("Vinicius");
		pessoa.setS("Sa");
		assertFalse(pessoa.existe());
	}

	@test
	void testWithWrongName() {
		
	}
}
