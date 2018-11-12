create database Schedule_Recreation;

use Schedule_Recreation;

create table Usuario (
nome_usuario varchar (20),
password_usuario varchar (20)
);

create table Livro (
nome_livro varchar(20),
nome_autor varchar(20),
nome_coautor varchar(20),
n_pag smallint,
comentarios varchar(450),
criticas varchar(450)
);

create table Serie(
nome_serie varchar(20),
qntd_temp smallint,
qntd_ep smallint,
qual_temp smallint,
qual_ep smallint,
comentarios varchar(450),
criticas varchar(450)
);

create table Filme(
nome_filme varchar(20),
nome_diretor varchar(20),
nome_produtor varchar(20),
temp_duracao smallint,
comentarios varchar(450),
criticas varchar(450)
);

