CREATE TABLE pessoas(
    codigo bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(60) not null,
    perfil varchar(10) not null,
    primary key (codigo)
);