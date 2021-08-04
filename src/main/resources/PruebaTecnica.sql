use pruebatecnica
go
CREATE TABLE ROL(
ID_ROL int identity,
NOMBRE varchar(50) not null,
primary key(ID_ROL)
)
go
CREATE TABLE USUARIO(
ID_USUARIO int identity,
ID_ROL int,
NOMBRE varchar(50) not null,
ACTIVO varchar(2) not null
primary key(ID_USUARIO)
)
go
ALTER TABLE ROL add constraint CK_NOMBRE check (NOMBRE IN ('ADMINISTRADOR','AUDITOR','AUXILIAR'))
go
alter table USUARIO
   add constraint FK_USUARIO_TIENE_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
go
insert into ROL(NOMBRE) values ('ADMINISTRADOR');
go
insert into ROL(NOMBRE) values ('AUDITOR');
go
insert into ROL(NOMBRE) values ('AUXILIAR');
go
SELECT * FROM ROL
go
ALTER TABLE USUARIO add constraint CK_ACTIVO check (NOMBRE IN ('SI','NO'))
go