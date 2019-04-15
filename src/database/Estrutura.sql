DROP DATABASE IF EXISTS feira_app;
CREATE DATABASE feira_app;
USE feira_app;
CREATE TABLE produtos(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150),
    tipo VARCHAR(100),
    peso FLOAT,
    validade DATE,
    disponivel BOOLEAN
);