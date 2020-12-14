package com.crudpessoa.crudpessoa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudpessoa.crudpessoa.model.Contato;
import com.crudpessoa.crudpessoa.model.Pessoa;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	Boolean existsByEmail(String email);
	Optional<Contato>findByEmail(String email);
}
