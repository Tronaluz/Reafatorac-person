package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import codigo.Pessoa;

class TestePessoa {

	@Test
	void pessoaExiste() { 
		Pessoa p = new Pessoa();
		p.setCadPessFis("007.650.419-01");
		p.setN("carlos");
		p.setS("pelegrin");
		assertTrue(p.existe());// verificar se o cpf está armazenado no formato correto, se o nome tem mais de 3 letras e se o sobrenome tem mais de 3 letras
	}
	
	@Test
	void formatoCPF() { // Fomarto do CPF deve ser sem pontos e traços e conter 11 digitos
		Pessoa p = new Pessoa();
		p.setCadPessFis("007.650.419-01");
		assertEquals("00765041901",p.getFmCadPessFis());
		assertEquals(11, p.getSizeCPF());
	}
}
