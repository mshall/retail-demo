/* Filling item table */
INSERT INTO item (item_id, item_name, item_type, item_price)
VALUES (1, 'Tomatoe', 1, 50);
INSERT INTO item (item_id, item_name, item_type, item_price)
VALUES (2, 'Cucumber', 1, 60);
INSERT INTO item (item_id, item_name, item_type, item_price)
VALUES (3, 'Pen', 2, 100);
INSERT INTO item (item_id, item_name, item_type, item_price)
VALUES (4, 'Shoes', 2, 50);
INSERT INTO item (item_id, item_name, item_type, item_price)
VALUES (5, 'Hand washer', 2, 100);

/* Filling customer type table */
INSERT INTO customer_type (customer_type_id, percentage_discount)
VALUES(3,30);

INSERT INTO customer_type (customer_type_id, percentage_discount)
VALUES(2,10);

INSERT INTO customer_type (customer_type_id, percentage_discount)
VALUES(1,5);

/* Filling customer  table */
INSERT INTO customer (customer_id, first_name, last_name, email, city, customer_type_id, member_since) 
VALUES (1, 'Grand', 'Shall', 'shall@gmail.com', 'Dubai', 3, '2015-03-01');
INSERT INTO customer (customer_id, first_name, last_name, email, city, customer_type_id, member_since) 
VALUES (2, 'Said', 'Shall', 'said@gmail.com', 'Dubai',2, '2017-03-01');
INSERT INTO customer (customer_id, first_name, last_name, email, city, customer_type_id, member_since) 
VALUES (3, 'Mohamed', 'Shall', 'mohamed@gmail.com', 'Dubai',1,'2018-02-01');
INSERT INTO customer (customer_id, first_name, last_name, email, city, customer_type_id, member_since) 
VALUES (4, 'Mohamed', 'Shall', 'mohamed@gmail.com', 'Dubai',1,'2020-02-01');