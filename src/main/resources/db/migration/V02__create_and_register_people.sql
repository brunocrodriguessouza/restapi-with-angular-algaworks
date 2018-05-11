CREATE TABLE people (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    street VARCHAR(50),
    number VARCHAR(20),
    complement VARCHAR(30),
    neighborhood VARCHAR(30),
    zipcode VARCHAR(20),
    city VARCHAR(30),
    state VARCHAR(20),
    active BOOLEAN DEFAULT false
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Bruno Souza', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Dayani Souza', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Gabriel Souza', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Filipe Souza', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Miguel Souza', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Ana Júlia', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Benedito Gonçalves', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', true);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Maria Inira', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', false);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Geralda Maria', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', false);
INSERT INTO people (name, street, number, complement, neighborhood, zipcode, city, state, active) values ('Antonio Bernardino', 'Rua dos Alecrins', '10', null, 'Cambuí', '13.058-000', 'Campinas', 'SP', false);
