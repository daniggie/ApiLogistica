CREATE TABLE pessoa_perfil(
    pessoa_id bigint not null,
    perfil_nome_perfil varchar(45) not null
);

ALTER TABLE pessoa_perfil ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) references pessoas(codigo);
ALTER TABLE pessoa_perfil ADD CONSTRAINT fk_perfil FOREIGN KEY (perfil_nome_perfil) references perfil(nome_perfil);