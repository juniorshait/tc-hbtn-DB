-- TABLE
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE pessoa (id bigint not null, cpf varchar(255) not null, dataDeNascimento datetime not null, email varchar(255) not null, idade integer not null, nome varchar(255) not null, primary key (id));
CREATE TABLE produto (id bigint not null, nome varchar(255) not null, preco double precision not null, quantidade integer not null, status boolean not null, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
