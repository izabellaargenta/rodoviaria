
CREATE DATABASE rodoviaria;
USE rodoviaria;

CREATE TABLE rodoviaria(
idOnibus int NOT NULL AUTO_INCREMENT PRIMARY KEY,
destino varchar(50),
origem varchar(50),
duracao int,
horario_s int,
horario_c int,
categoria varchar(50)
);