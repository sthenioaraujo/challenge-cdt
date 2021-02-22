create table payment (
	id bigint(20) primary key auto_increment,
    number_card varchar(255),
    payment_date date,
    status bigint(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;