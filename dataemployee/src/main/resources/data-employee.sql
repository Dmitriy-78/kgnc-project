DROP TABLE IF EXISTS kgnc_work_address;
DROP TABLE IF EXISTS kgnc_telephone;
DROP TABLE IF EXISTS kgnc_employee_data;

CREATE TABLE kgnc_work_address(
   work_address_id SERIAL,
   building varchar(10) not null,
   office_name varchar (10) not null,
   PRIMARY KEY (work_address_id)
);

CREATE TABLE kgnc_telephone(
   tel_number_id SERIAL,
   number varchar(10) not null,
   PRIMARY KEY (tel_number_id)
);

CREATE TABLE kgnc_employee_data(
   employee_data_id SERIAL,
   work_address_id integer not null,
   tel_number_id integer not null,
   sur_name varchar(50),
   given_name varchar(50),
   patronymic varchar(50),
   date_of_birth date,
   position varchar(100),
   tabel_number varchar(10),
   PRIMARY KEY (employee_data_id),
   FOREIGN KEY (work_address_id) REFERENCES kgnc_work_address(work_address_id) ON DELETE RESTRICT,
   FOREIGN KEY (tel_number_id) REFERENCES kgnc_telephone(tel_number_id) ON DELETE RESTRICT
);