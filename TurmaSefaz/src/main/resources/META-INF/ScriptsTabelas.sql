-- Scripts para criação do projeto --

CREATE TABLE usuario (
	cpf VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
 	PRIMARY KEY (cpf) 
);

CREATE TABLE jogo (
	id INT NOT NULL,
	nome VARCHAR(100) NOT NULL,
  genero VARCHAR(100) NOT NULL,
  nome_plataforma VARCHAR(100) NOT NULL,
  PRIMARY KEY (id) 
);

CREATE TABLE plataforma (
	nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (nome) 
);

ALTER TABLE jogo
ADD FOREIGN KEY (nome_plataforma) 
REFERENCES plataforma(nome);

CREATE SEQUENCE S_JOGO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;