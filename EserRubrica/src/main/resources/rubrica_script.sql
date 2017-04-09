# #####################
#Create database Rubrica
# #####################

DROP DATABASE IF EXISTS Rubrica;

CREATE DATABASE IF NOT EXISTS Rubrica 
			DEFAULT CHARACTER SET utf8
	DEFAULT COLLATE utf8_unicode_ci;
    
USE Rubrica;

#Table structure for table 'Persona'

DROP TABLE IF EXISTS Persona;

CREATE TABLE IF NOT EXISTS Persona(
	num_cell INT NOT NULL,
	name VARCHAR(20) NOT NULL,
    cognome VARCHAR(20) NOT NULL,    
    email VARCHAR(40) NOT NULL,
    indirizzo VARCHAR(40) NOT NULL,
    telefono INT NOT NULL,
    CONSTRAINT pk_numcell PRIMARY KEY(num_cell),
    CONSTRAINT fk_cell FOREIGN KEY(telefono) REFERENCES Cellulare(id) 
);

#Table structure for table 'Cellulare'

DROP TABLE IF EXISTS Cellulare;

CREATE TABLE IF NOT EXISTS Cellulare(
	id INT(11) NOT NULL,
	name VARCHAR(64) NOT NULL,
	ram VARCHAR(5) NOT NULL,
	cpu VARCHAR(64) NOT NULL,
	displayPpi INT(11) NOT NULL,
	displaySize VARCHAR(12) NOT NULL,
	displayResolution VARCHAR(64) NOT NULL,
	size VARCHAR(64) NOT NULL,
	weight INT(4) NOT NULL,
	brand INT(11) NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY(id),
    CONSTRAINT fk_brand FOREIGN KEY(brand) REFERENCES Brand(id) 
);

#Table structure for table 'Brand'

DROP TABLE IF EXISTS Brand;

CREATE TABLE Brand(
	id INT(11) NOT NULL,
	name VARCHAR(32) NOT NULL,
	description VARCHAR(64) NOT NULL,
	company VARCHAR(64) NOT NULL,
    CONSTRAINT pk_id PRIMARY KEY(id)
    
    
);

