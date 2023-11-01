package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import codigo.Person;

class TestPerson {

	@Test
	void testExisteComCpfInvalido() {
		Person person = new Person('357.860.440-25', 'Jose', 'Arnaldo');
		assertTrue(person.getSizeCPF() > 9);
	}

	@Test
	void testExisteComNomeInvalido() {
		AssertionError(Person person = new Person('357.860.440-25', '', 'Arnaldo'));
	}

	@Test
	void testExisteComSobrenomeInvalido() {
		AssertionError(Person person = new Person('357.860.440-25', 'Arnaldo', ''));
	}

	@Test
	void testCPFInvalid() {
		AssertionError(Person person = new Person('666.666.666-66', 'Arnado', 'Jose'))
	}
}
