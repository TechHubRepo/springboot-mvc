create table customers (
    contact_id bigint not null auto_increment,
    created_on date,
    contact_name varchar(50) not null,
    date_of_birth date,
    description varchar(255),
    emails varchar(255) not null,
    gender varchar(10),
    mobile_number bigint not null,
    price decimal(38,2),
    services_taken varchar(255),
    updated_on date,
    primary key (contact_id)
) engine=InnoDB
