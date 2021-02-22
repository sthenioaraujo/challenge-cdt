create table order_item (
	item_id bigint(20) primary key auto_increment,
    description varchar(255),
    quantity bigint(20),
    unit_price decimal(10,2),
    id_order bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into order_item (description, quantity, unit_price, id_order) values ('Product Test ACME', 2, 15.0,1);