CREATE TABLE usuarios(
	
    id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
    nome VARCHAR(100) NOT NULL,
    bio VARCHAR(255),
    deletado BOOLEAN,
    data_criacao DATE,
    nome_usuario VARCHAR (200) NOT NULL,
    numero VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    foto_link VARCHAR(255),
    data_atualizacao DATE,
    
    PRIMARY KEY (id)
);