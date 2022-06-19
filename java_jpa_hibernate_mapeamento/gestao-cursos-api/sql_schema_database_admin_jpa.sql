-- TABLE
CREATE TABLE aluno (id bigint not null, dataDeNascimento date not null, email varchar(255) not null, matricula varchar(255) not null, nomecompleto varchar(255) not null, aluno_curso bigint, primary key (id));
CREATE TABLE curso (id bigint not null, nome varchar(255) not null, sigla varchar(255) not null, materialCurso_id bigint, professor_curso bigint, primary key (id));
CREATE TABLE endereco (id bigint not null, bairro varchar(255) not null, cep integer not null, cidade varchar(255) not null, endereco varchar(255) not null, estado varchar(255) not null, logadouro varchar(255) not null, numero varchar(255) not null, aluno_id bigint, primary key (id));
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE materialcurso (id bigint not null, url varchar(255) not null, primary key (id));
CREATE TABLE professor (id bigint not null, email varchar(255) not null, matricula varchar(255) not null, nomecompleto varchar(255) not null, primary key (id));
CREATE TABLE telefone (id bigint not null, ddd varchar(255) not null, telefone varchar(255) not null, aluno_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
