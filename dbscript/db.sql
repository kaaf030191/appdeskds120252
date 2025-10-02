create database dbds120252;
use dbds120252;

create table tperson
(
idPerson char(36) not null,
firstName varchar(70) not null,
surName varchar(40) not null,
gender boolean not null,
birthDate date not null,
createdAt datetime not null,
updatedAt datetime not null,
primary key(idPerson)
) engine = innodb;