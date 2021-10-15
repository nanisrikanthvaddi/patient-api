
create table IF NOT EXISTS   patient_info   (
    name varchar(64) ,
    nric varchar(64) not null,
    birth_date varchar(64),
    address varchar(64),
    phone_num varchar(64)
    );