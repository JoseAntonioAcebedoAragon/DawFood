drop database if exists DawFood;
create database if not exists DawFood;
use DawFood;

drop table if exists categoria;
create table if not exists categoria (
	idCategoria bigint not null auto_increment,
	nombreCategoria enum('Comida','Bebida','Postre') not null,
	nombreSubCategoria varchar(100) not null,
	constraint pk_categoria primary key (idCategoria)
);

drop table if exists pedido;
create table if not exists pedido (
	idPedido bigint not null auto_increment,
    fechaHoraPedido datetime not null default current_timestamp,
    precioPedido decimal(6,2) not null,
    idTransaccion varchar(100) not null,
	constraint pk_pedido primary key (idPedido)
);

drop table if exists usuario;
create table if not exists usuario (
	idUsuario bigint not null auto_increment,
	nombreUsuario varchar(100) not null,
	correoElectronico varchar(100) not null,
	contrasena varchar(100) not null,
	constraint pk_usuario primary key (idUsuario)
);

drop table if exists producto;
create table if not exists producto (
	idProducto bigint not null auto_increment,
    nombreProducto varchar(100) not null,
    precioProducto decimal(5,2) not null,
    ivaProducto decimal (4,2) not null,
    stockProducto int not null,
    descripcion varchar(200),
	idCategoria bigint not null,
    constraint pk_producto primary key (idProducto),
	constraint fk_categoria_producto foreign key (idCategoria) references categoria (idCategoria)
		on delete no action on update cascade
);

drop table if exists detallePedido;
create table if not exists detallePedido (
	idPedido bigint not null,
    idProducto bigint not null,
	cantidadProducto int not null,
    constraint pk_detallePedido primary key (idPedido,idProducto),
    constraint fk_pedido_detallePedido foreign key (idPedido) references pedido (idPedido)
		on delete no action on update cascade,
	constraint fk_producto_detallePedido foreign key (idProducto) references producto (idProducto)
		on delete no action on update cascade
);