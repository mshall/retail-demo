
CREATE TABLE WEATHER
(
     weather_id IDENTITY NOT NULL,
     weather_date DATE NOT NULL,
     lat  FLOAT NOT NULL,
     lon   FLOAT NOT NULL,
     city       VARCHAR2(150) NOT NULL,
     state        VARCHAR2(150) NOT NULL,
     temperatures    VARCHAR2(240) NOT NULL
);

CREATE TABLE customer
  (
     customer_id NUMBER(10) NOT NULL,
     first_name  VARCHAR2(50) NOT NULL,
     last_name   VARCHAR2(50) NOT NULL,
     email       VARCHAR2(150) NOT NULL,
     city        VARCHAR2(150) NOT NULL,
     customer_type_id     NUMBER(10) NOT NULL,
     member_since DATE NOT NULL,
     PRIMARY KEY(customer_id)
  );

CREATE TABLE customer_type
  (
     customer_type_id             NUMBER(10) NOT NULL,
     percentage_discount NUMBER(10) NOT NULL,
     PRIMARY KEY(customer_type_id)
  ); 
  

CREATE TABLE item
  (
     item_id NUMBER(10) NOT NULL,
     item_name  VARCHAR2(50) NOT NULL,
     item_type    NUMBER(10) NOT NULL,
     item_price DOUBLE NOT NULL,
     PRIMARY KEY(item_id)
  );



  
  