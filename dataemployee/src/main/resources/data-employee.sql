DROP TABLE IF EXISTS kgnc_work_address;
DROP TABLE IF EXISTS kgnc_telephone;
DROP TABLE IF EXISTS kgnc_employee_data;

CREATE TABLE kgnc_employee_data(
   employee_id SERIAL,
   sur_name varchar(50),
   given_name varchar(50),
   patronymic varchar(50),
   date_of_birth date,
   position varchar(100),
   tabel_number varchar(10),
   PRIMARY KEY (employee_id)
);

CREATE TABLE kgnc_work_address(
   work_address_id SERIAL,
   employee_id integer not null,
   building varchar(10) not null,
   office_number varchar (10) not null,
   PRIMARY KEY (work_address_id),
   FOREIGN KEY (employee_id) REFERENCES kgnc_employee_data(employee_id) ON DELETE RESTRICT
);

CREATE TABLE kgnc_telephone(
   tel_number_id SERIAL,
   employee_id integer not null,
   tel_number varchar(10) not null,
   PRIMARY KEY (tel_number_id),
   FOREIGN KEY (employee_id) REFERENCES kgnc_employee_data(employee_id) ON DELETE RESTRICT
);

INSERT INTO kgnc_employee_data(sur_name,given_name,patronymic,date_of_birth,position,tabel_number)
VALUES
('Васильев','Павел','Николаевич','1968-04-05','Ведущий инженер','04061212'),
('Лосев','Сергей','Петрович','194-01-10','Инженер 2 категории','04061313'),
('Орлова','Анна','Олеговна','1995-10-21','Научный сотрудник','04061414');

INSERT INTO kgnc_work_address(employee_id,building,office_number)
VALUES
(1,'24 Бис(Б)','425'),
(2,'24 Бис(Б)','422'),
(3,'24 Бис(Б)','424');

INSERT INTO kgnc_telephone(employee_id,tel_number)
VALUES
(1,'1234'),
(1,'1234525'),
(2,'2345'),
(3,'3456');

