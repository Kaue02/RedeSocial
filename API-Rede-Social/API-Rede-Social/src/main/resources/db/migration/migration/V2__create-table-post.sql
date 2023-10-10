CREATE TABLE post(
	
    id BIGINT NOT NULL AUTO_INCREMENT UNIQUE,
    id_usuario BIGINT,
    titulo VARCHAR(50) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    deletado BOOLEAN,
    post_privado BOOLEAN,
    foto_link VARCHAR(255),
    video_link VARCHAR(255),
    data_atualizacao DATE,
	data_criacao DATE,
    
	FOREIGN KEY (id_usuario) REFERENCES usuarios (id),
    
    PRIMARY KEY (id)
);