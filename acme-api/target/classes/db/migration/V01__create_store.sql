create table store (
	id bigint(20) primary key auto_increment,
    name varchar(50),
    adress varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO store (name, adress) values ('ACME Store', '123 Express Avenue');