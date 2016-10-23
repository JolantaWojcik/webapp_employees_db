create table employees(
	id integer generated always as identity,
	name varchar(255) not null,
	surname varchar(255) not null, 
	position varchar(255) not null, 
	salary integer not null,
	primary key(id)
);
insert into employees values(name, surname, position, salary) values ('Jan', 'Kowaslki', 'Programista', 4000);
insert into employees values(name, surname, position, salary) values ('Franek', 'Kowaslki', 'Programista', 6000);
insert into employees values(name, surname, position, salary) values ('Anna', 'Kowaslka', 'Programista', 7000);
insert into employees values(name, surname, position, salary) values ('Kasia', 'Kowaslka', 'Analityk', 3000);
insert into employees values(name, surname, position, salary) values ('Ola', 'Kowaslka', 'Manager', 11000);

create table user_account(
	id integer generated always as identity,
	user_name varchar(255) not null,
	password varchar(255) not null,
	primary key(id)
);
insert into user_account values(user_name, password) values ('admin', 'admin');
insert into user_account values(user_name, password) values ('test', 'test');

