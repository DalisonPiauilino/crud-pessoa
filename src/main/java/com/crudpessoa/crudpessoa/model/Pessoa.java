package com.crudpessoa.crudpessoa.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	private String cpf;
	private Timestamp data_nascimento;
	private String estado;
	private String cidade;
	private String cep;
	
	@OneToMany(
			mappedBy = "pessoa",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private Set<Contato> contatos;
	
}
