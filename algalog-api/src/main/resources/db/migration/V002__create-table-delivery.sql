create table delivery (
	id bigint not null auto_increment,
	client_id bigint not null,
	rate decimal(10,2) not null,
	status varchar(20) not null,
	date_order datetime not null,
	date_finish datetime,
	recipient_nome varchar(60) not null,
	recipient_logradouro varchar(255) not null,
	recipient_numero varchar(30) not null,
	recipient_complemento varchar(60) not null,
	recipient_bairro varchar(30) not null,
	
	primary key(id)
);
alter table delivery add constraint fk_delivery_client foreign key(client_id) references clients(id);