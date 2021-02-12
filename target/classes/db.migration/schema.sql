CREATE TABLE IF NOT EXISTS product (
   id  PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   price DECIMAL(12,2) DEFAULT 0,
   created_date LONG NOT NULL,
   modified_date LONG NOT NULL,

);

