START TRANSACTION ;
CREATE DATABASE homework7;
USE homework7;
CREATE TABLE product(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) not null,
    price bigint
);
INSERT INTO product(name,price)
    VALUES ('baikal',60), ('kvass',70), ('tarragon',70);
COMMIT;