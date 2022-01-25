DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT (
accountNumber INTEGER PRIMARY KEY NOT NULL,
pin INTEGER NOT NULL,
firstname VARCHAR(50) NOT NULL, 
lastname VARCHAR(50) NOT NULL, 
balance INTEGER NOT NULL,
overdraft INTEGER NOT NULL
);

DROP TABLE IF EXISTS ATM;
CREATE TABLE ATM (
id INTEGER PRIMARY KEY NOT NULL,
location VARCHAR(50),
fifty INTEGER,
twenty INTEGER,
ten INTEGER, 
five INTEGER
);