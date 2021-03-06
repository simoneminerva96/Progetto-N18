USE PROGETTON;

DROP TABLE IF EXISTS BOOKEDFLIGHTS;
DROP TABLE IF EXISTS TICKETS;
DROP TABLE IF EXISTS FLIGHTS;
DROP TABLE IF EXISTS PAYMENTS;
DROP TABLE IF EXISTS AIRPORTS;
DROP TABLE IF EXISTS AIRPLANES;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
		USERNAME VARCHAR(20) NOT NULL,
		PWD VARCHAR(20) NOT NULL,
		NOME VARCHAR(20) NOT NULL,
		SURNAME VARCHAR(20) NOT NULL,
		BIRTHDATE VARCHAR(10) NOT NULL,
		NATION VARCHAR(50) NOT NULL,
		EMAIL VARCHAR(50) NOT NULL,
		PRIMARY KEY(USERNAME)
);

CREATE TABLE PAYMENTS (
		ID VARCHAR(16) NOT NULL,
		METHOD VARCHAR(10) NOT NULL,
		HOLDER VARCHAR(20) NOT NULL,
		FOREIGN KEY (HOLDER) REFERENCES USERS(USERNAME),
		PRIMARY KEY(ID)
);

CREATE TABLE AIRPORTS (
		IATA VARCHAR(3) NOT NULL,
		NOME VARCHAR(100) NOT NULL,
		CITY VARCHAR(50) NOT NULL,
		NATION VARCHAR(50) NOT NULL,
		PRIMARY KEY(IATA)
);

CREATE TABLE AIRPLANES (
		ID VARCHAR(5) NOT NULL,
		ECONOMY INT,
		BUSINESS INT,
		PRIMARY KEY(ID)
);

CREATE TABLE FLIGHTS (
		ID VARCHAR(9) NOT NULL,
		DEPARTURE VARCHAR(3) NOT NULL,
		ARRIVE VARCHAR(3) NOT NULL,
		DATED TIME NOT NULL,
		DATEA TIME NOT NULL,
		AIRPLANE VARCHAR(5) NOT NULL,
		FOREIGN KEY (DEPARTURE) REFERENCES AIRPORTS(IATA),
		FOREIGN KEY (ARRIVE) REFERENCES AIRPORTS(IATA),
		FOREIGN KEY (AIRPLANE) REFERENCES AIRPLANES(ID),
		PRIMARY KEY(ID)
);

CREATE TABLE BOOKEDFLIGHTS(
        ID VARCHAR(9) NOT NULL,
		DDATE VARCHAR(10) NOT NULL,
		ESEAT INT NOT NULL,
        BSEAT INT NOT NULL,
        FOREIGN KEY (ID) REFERENCES FLIGHTS(ID),
		PRIMARY KEY(ID, DDATE)
);

CREATE TABLE TICKETS(
		ID VARCHAR(20) NOT NULL,
        FLIGHTUSER VARCHAR(30) NOT NULL,
		HOLDER VARCHAR(20) NOT NULL,
		FLIGHT VARCHAR(9) NOT NULL,
        DDATE VARCHAR(10) NOT NULL,
		BAGGAGE VARCHAR(6) NOT NULL,
		SEAT VARCHAR(8) NOT NULL,
        NSEAT VARCHAR(3) NOT NULL,
		CHECKED TINYINT(1) NOT NULL,
		FOREIGN KEY (FLIGHTUSER) REFERENCES USERS(USERNAME),
		FOREIGN KEY (FLIGHT) REFERENCES FLIGHTS(ID),
		PRIMARY KEY(ID)
);

