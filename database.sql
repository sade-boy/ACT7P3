CREATE DATABASE login_app;

USE login_app;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre_completo VARCHAR(100)
);

INSERT INTO usuarios(username,password,nombre_completo)
VALUES
('admin','1234','Administrador Principal');
