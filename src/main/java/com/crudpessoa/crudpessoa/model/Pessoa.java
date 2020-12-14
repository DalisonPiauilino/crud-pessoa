package com.crudpessoa.crudpessoa.model;

import java.sql.Timestamp;
import java.util.HashSet;
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
	
	public Pessoa() {
        contatos = new HashSet<>();
    }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Timestamp getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Timestamp data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Contato getContatos() {
		return (Contato) contatos;
	}
	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}
	public void addContato(Contato contato) {
		if (contato != null) {
			this.contatos.add(contato);
			contato.setPessoa(this);
		}		
	}
}
