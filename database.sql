CREATE DATABASE login_app;
USE login_app;

CREATE TABLE usuarios(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100)
);

INSERT INTO usuarios(username, password)
VALUES('admin', '12345');