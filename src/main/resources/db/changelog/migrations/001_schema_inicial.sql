--liquibase formatted sql

--changeset dalisonpiauilino:1
CREATE TABLE tb_pessoa (
	id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY CONSTRAINT pk_pessoa PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	data_nascimento TIMESTAMP NOT NULL,
	estado VARCHAR(2),
	cidade VARCHAR(100),
	cep VARCHAR(8)	
);

CREATE TABLE tb_contato (
	id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY CONSTRAINT pk_contato PRIMARY KEY,
	email VARCHAR(100),
	telefone VARCHAR(11),
	skype VARCHAR(100) ,
	pessoa_id INTEGER CONSTRAINT fk_contato_pessoa REFERENCES tb_pessoa
);

--rollback ALTER TABLE tb_contato DROP CONSTRAINT fk_contato_pessoa;
--rollback DROP TABLE tb_contato;
--rollback DROP TABLE tb_pessoa;

