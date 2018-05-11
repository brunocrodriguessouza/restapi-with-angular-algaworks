CREATE TABLE expense (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    value DECIMAL(10,2) NOT NULL,
    note VARCHAR(100),
    type VARCHAR(20) NOT NULL,
    category_id BIGINT(20) NOT NULL,
    people_id BIGINT(20) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (people_id) REFERENCES people(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Salário mensal', '2018-01-27', null, 6500.00, 'Distribuição de lucros', 'INCOME', 1, 1);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Supermercado', '2018-03-10', '2018-03-01', 100.32, null, 'EXPENSE', 2, 2);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Academia', '2018-04-10', null, 120, null, 'EXPENSE', 3, 3);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Conta de luz', '2018-02-10', '2018-02-10', 110.44, null, 'EXPENSE', 3, 4);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Conta de água', '2018-02-15', null, 200.30, null, 'EXPENSE', 3, 5);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Restaurante', '2018-03-14', '2018-03-14', 1010.32, null, 'EXPENSE', 4, 6);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Venda vídeo game', '2018-01-01', null, 500, null, 'INCOME', 1, 7);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Clube', '2018-03-07', '2018-03-05', 400.32, null, 'EXPENSE', 4, 8);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Impostos', '2018-04-10', null, 123.64, 'Multas', 'EXPENSE', 3, 9);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Multa', '2018-04-10', null, 665.33, null, 'EXPENSE', 5, 10);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Padaria', '2018-02-28', '2018-02-28', 8.32, null, 'EXPENSE', 1, 5);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Papelaria', '2018-02-10', '2018-04-10', 2100.32, null, 'EXPENSE', 5, 4);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Almoço', '2018-03-09', null, 1040.32, null, 'EXPENSE', 4, 3);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Café', '2018-02-20', '2018-02-18', 4.32, null, 'EXPENSE', 4, 2);
INSERT INTO expense (description, due_date, payment_date, value, note, type, category_id, people_id) values ('Lanche', '2018-04-10', null, 10.20, null, 'EXPENSE', 4, 1);

