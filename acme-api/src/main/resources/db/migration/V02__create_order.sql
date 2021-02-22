create table tborder (
	id bigint(20) primary key auto_increment,
    release_date date,
    order_status bigint(20),
    id_payment bigint(20),
    id_store bigint(20),
	adress varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tborder (release_date, order_status, id_store, adress) values ('2021-02-21', 1, 1, 'Test Adress');