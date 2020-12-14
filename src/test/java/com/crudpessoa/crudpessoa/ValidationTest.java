package com.crudpessoa.crudpessoa;

import com.crudpessoa.crudpessoa.model.Contato;
import com.crudpessoa.crudpessoa.model.Pessoa;
import com.crudpessoa.crudpessoa.repository.PessoaRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationTest {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void test() {
		  Pessoa pessoa = buildPessoa();

		  Pessoa savedPessoa = pessoaRepository.save(pessoa);

	      Assert.assertNotNull(savedPessoa.getId());
	      Assert.assertNotNull(savedPessoa.getContatos().getId());
          Assert.assertEquals("dalison.piauilino@gmail.com", savedPessoa.getContatos().getEmail());
	}

	private Pessoa buildPessoa() {
		
		String input = "1988-10-28 12:13:14" ;
		java.sql.Timestamp ts = java.sql.Timestamp.valueOf( input ) ;
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Dalison Piauilino");
		pessoa.setCpf("00000000191");
		pessoa.setData_nascimento(ts);

		pessoa.addContato(buildContato());

	    return pessoa;
	}

	private Contato buildContato() {
		Contato contato = new Contato();
		contato.setEmail("dalison.piauilino@gmail.com");

        return contato;
	}

}
