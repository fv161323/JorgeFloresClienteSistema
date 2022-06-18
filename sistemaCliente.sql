create database PruebaCliente;
use Pruebacliente;

/*CREACION DE TABLAS*/

create table direccion(
idDireccion int primary key auto_increment not null,
direccionPrincipal varchar(75),
direccionSecundaria varchar(75)
);

create table documento(
idDocumento int primary key auto_increment not null,
dui varchar(10) unique,
pasaporte varchar(15) unique,
nit varchar(17) unique
);

create table cliente (
idCliente int primary key auto_increment not null,
nombre varchar(25),
apellido varchar(25),
edad int,
idDireccion int,
idDocumento int,
constraint FK_clienteDireccion foreign key (idDireccion) references direccion(idDireccion)
on delete cascade
on update cascade,
constraint FK_clienteDocumento foreign key (idDocumento) references documento(idDocumento)
on delete cascade
on update cascade
);

create table BitacoraCliente(
idBitacora int primary key auto_increment,
idCliente int,
nombre varchar(25),
apellido varchar(25),
edad int,
idDocumento int,
idDireccion int,
usuario varchar(25),
fecha datetime,
accion varchar(35)
);

create table BitacoraDocumento(
idBitacora int primary key auto_increment,
idDocumento int,
dui varchar(25),
pasaporte varchar(25),
nit varchar(20),
usuario varchar(25),
fecha datetime,
accion varchar(35)
);

create table BitacoraDireccion(
idBitacora int primary key auto_increment,
idDireccion int,
direccionPrincipal varchar(50),
direccionSecundaria varchar(50),
usuario varchar(25),
fecha datetime,
accion varchar(35)
);

/*INSERCION DE DATOS*/

insert into documento(dui,pasaporte,nit) values("05528654-4","A912341451","1234-142123-124-1");
insert into direccion(direccionPrincipal,direccionSecundaria) values("Soyapango","San Salvador");
insert into cliente(nombre,apellido,edad,idDireccion,idDocumento) values("jorge","Flores",12,1,1);

/*TRIGGERS AUDITORIA*/

CREATE trigger InsertarCliente after insert ON cliente
FOR each row INSERT INTO BitacoraCliente(idCliente,nombre,apellido,edad,idDocumento,idDireccion,usuario,fecha,accion)
VALUES(NEW.IdCliente,NEW.nombre,NEW.apellido,NEW.edad,NEW.idDocumento,New.idDireccion,USER(),NOW(),'INSERT');

CREATE trigger ActualizarCliente after update ON cliente
FOR each row INSERT INTO BitacoraCliente(idCliente,nombre,apellido,edad,idDocumento,idDireccion,usuario,fecha,accion)
VALUES(NEW.IdCliente,NEW.nombre,NEW.apellido,NEW.edad,NEW.idDocumento,New.idDireccion,USER(),NOW(),'UPDATE');

CREATE trigger EliminarCliente after delete ON cliente
FOR each row INSERT INTO BitacoraCliente(idCliente,nombre,apellido,edad,idDocumento,idDireccion,usuario,fecha,accion)
VALUES(OLD.IdCliente,OLD.nombre,OLD.apellido,OLD.edad,OLD.idDocumento,OLD.idDireccion,USER(),NOW(),'DELETE');

CREATE trigger InsertarDocumento after insert ON documento
FOR each row INSERT INTO BitacoraDocumento(idDocumento,dui,pasaporte,nit,usuario,fecha,accion)
VALUES(NEW.idDocumento,NEW.dui,NEW.pasaporte,NEW.nit,USER(),NOW(),'INSERT');

CREATE trigger ActualizarDocumento after update ON documento
FOR each row INSERT INTO BitacoraDocumento(idDocumento,dui,pasaporte,nit,usuario,fecha,accion)
VALUES(NEW.idDocumento,NEW.dui,NEW.pasaporte,NEW.nit,USER(),NOW(),'UPDATE');

CREATE trigger EliminarDocumento after delete ON documento
FOR each row INSERT INTO BitacoraDocumento(idDocumento,dui,pasaporte,nit,usuario,fecha,accion)
VALUES(OLD.idDocumento,OLD.dui,OLD.pasaporte,OLD.nit,USER(),NOW(),'DELETE');

CREATE trigger InsertarDireccion after insert ON direccion
FOR each row INSERT INTO BitacoraDireccion(idDireccion,direccionPrincipal,direccionSecundaria,usuario,fecha,accion)
VALUES(NEW.idDireccion,NEW.direccionPrincipal,NEW.direccionSecundaria,USER(),NOW(),'INSERT');

CREATE trigger ActualizarDireccion after update ON direccion
FOR each row INSERT INTO BitacoraDireccion(idDireccion,direccionPrincipal,direccionSecundaria,usuario,fecha,accion)
VALUES(NEW.idDireccion,NEW.direccionPrincipal,NEW.direccionSecundaria,USER(),NOW(),'UPDATE');

CREATE trigger EliminarDireccion after delete ON direccion
FOR each row INSERT INTO BitacoraDireccion(idDireccion,direccionPrincipal,direccionSecundaria,usuario,fecha,accion)
VALUES(OLD.idDireccion,OLD.direccionPrincipal,OLD.direccionSecundaria,USER(),NOW(),'DELETE');

