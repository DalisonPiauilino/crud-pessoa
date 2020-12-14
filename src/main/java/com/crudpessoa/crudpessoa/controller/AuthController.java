package com.crudpessoa.crudpessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudpessoa.crudpessoa.repository.ContatoRepository;
import com.crudpessoa.crudpessoa.repository.PessoaRepository;

@CrossOrigin (origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	PasswordEncoder encoder;

}
