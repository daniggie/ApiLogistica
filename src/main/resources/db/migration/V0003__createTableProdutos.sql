CREATE TABlE produtos(
	codigo int not null auto_increment,
	produto varchar(20) not null,
	quantidade int not null,
	valor_unitario decimal not null,
	valor_estoque decimal not null,

	PRIMARY KEY (codigo)
);