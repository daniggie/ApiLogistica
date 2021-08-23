ALTER TABLE pessoas ADD CONSTRAINT fk_pessoa_perfil
FOREIGN KEY (perfil) REFERENCES perfil (nome_perfil);