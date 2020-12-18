package com.crudpessoa.crudpessoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudpessoa.crudpessoa.model.Pessoa;
import com.crudpessoa.crudpessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
    private PessoaRepository pessoaRepository;
	
	@GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable(value = "id") Long pessoaId)
        throws Exception {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
          .orElseThrow(() -> new Exception("Pessoa not found for this id :: " + pessoaId));
        return ResponseEntity.ok().body(pessoa);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    public Map<String, Boolean> deletePessoa(@PathVariable(value = "id") Long pessoaId)
         throws Exception {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
       .orElseThrow(() -> new Exception("Pessoa not present for the id :: " + pessoaId));

        pessoaRepository.delete(pessoa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable(value = "id") Long pessoaId,
        @Valid @RequestBody Pessoa pessoaDetails) 
        throws  Exception {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new Exception("Pessoa not found for this id :: " + pessoaId));

        final Pessoa updatedPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(updatedPessoa);
    }
}
