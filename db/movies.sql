CREATE DATABASE movies;
CREATE TABLE studio (
    name varchar(15) not null UNIQUE,
    address varchar(15),
    presc int,
    Primary key(name)
); 

CREATE TABLE movieStar (
    name varchar(15) not null UNIQUE,
    address varchar(15),
    gender enum('men','women'),
    birthdate int,
    Primary key(name)
);



CREATE TABLE movieExec (
    cert int not null UNIQUE,
    name varchar(15),
    address varchar(15),
    network varchar(15),
    Primary key(cert)
);
 
 CREATE TABLE movie (
 	title varchar(15) not null ,
 	year int not null,
 	length int,
 	incolor boolean,
 	studioName varchar(15),
 	producerc int,
 	Primary key(title,year),
 	FOREIGN KEY (studioName) REFERENCES studio(name),
 	FOREIGN KEY (producerc) REFERENCES movieExec(cert),
    UNIQUE(title,year)
 );
 
 CREATE TABLE starsIn (
    movietitle varchar(15),
    movieyear int,
    starName varchar(15) not null,
    FOREIGN KEY (movietitle,movieyear) REFERENCES movie(title,year),
    FOREIGN KEY (starName) REFERENCES movieStar(name)
);