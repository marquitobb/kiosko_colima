create database kiosko; --aqui cree la base de datos llamada kiosko

use kiosko;


create table productos(
clave int constraint pk_clave primary key,
nombre varchar(60),
cantida int
);

drop table productos

select * from productos p where clave = 22 

--insercion*********************************************************************************
insert into productos values
(2,'corona',5);



create procedure ingresar @clave int, @nombre varchar(60), @cantidad int as
begin
	insert into productos values
	(@clave,@nombre,@cantidad);

end


ingresar 19,'papitas',4


update productos
set cantida += 2
where clave = 22

--manda la tabla que se modifico tabla 
alter trigger TR_modifica_cantidad  
on productos
after update 
as 
select * from inserted

--cree un trigger manda tabla cuando se ingresa un nuevo producto
create trigger TR_inserta_producto 
on productos
after insert
as 
select * from inserted 
 
--aqui seleccionamos la opcion de borrar
delete from productos where clave = 11

select * from productos;
