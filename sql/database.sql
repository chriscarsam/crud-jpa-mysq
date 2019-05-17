CREATE DATABASE dbappwebcrud;
USE dbappwebcrud;

CREATE TABLE tperson
(
	id INT AUTO_INCREMENT,
    firstName VARCHAR(70) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    documentIdentification VARCHAR(13) NOT NULL,
    email VARCHAR(700) NOT NULL,
    birthdate DATE NOT NULL,
    registrationDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    PRIMARY KEY(id)
);