CREATE TABLE IF NOT EXISTS business (
   id serial PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   description TEXT,
   status VARCHAR(255) DEFAULT 'enable',
   created_date BIGINT NOT NULL,
   modified_date BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS place (
   id serial PRIMARY KEY,
   business_id INT NOT NULL,
   name VARCHAR(255) NOT NULL,
   description TEXT,
   status VARCHAR(255) DEFAULT 'enable',
   created_date BIGINT NOT NULL,
   modified_date BIGINT NOT NULL,
   CONSTRAINT fk_place_business FOREIGN KEY(business_id) REFERENCES business(id)
);

CREATE TABLE IF NOT EXISTS product (
   id serial PRIMARY KEY,
   business_id INT NOT NULL,
   place_id INT NOT NULL,
   name VARCHAR(255) NOT NULL,
   description TEXT,
   price DECIMAL(12,2) DEFAULT 0,
   created_date BIGINT NOT NULL,
   modified_date BIGINT NOT NULL,
   CONSTRAINT fk_product_business FOREIGN KEY(business_id) REFERENCES business(id),
   CONSTRAINT fk_product_place FOREIGN KEY(place_id) REFERENCES place(id)
);

CREATE TABLE IF NOT EXISTS place_table (
   id serial PRIMARY KEY,
   business_id INT NOT NULL,
   place_id INT NOT NULL,
   name VARCHAR(255) NOT NULL,
   description TEXT,
   status VARCHAR(255) DEFAULT 'enable',
   created_date BIGINT NOT NULL,
   modified_date BIGINT NOT NULL,
   CONSTRAINT fk_place_table_business FOREIGN KEY(business_id) REFERENCES business(id),
   CONSTRAINT fk_place_table_place FOREIGN KEY(place_id) REFERENCES place(id)
);

CREATE TABLE IF NOT EXISTS table_order_detail (
   id serial PRIMARY KEY,
   place_table_id INT NOT NULL,
   product_id INT NOT NULL,
   product_name VARCHAR(255) NOT NULL,
   description TEXT,
   price DECIMAL(12,2) DEFAULT 0,
   amount INT NOT NULL,
   CONSTRAINT fk_table_order_detail_place_table FOREIGN KEY(place_table_id) REFERENCES place_table(id),
   CONSTRAINT fk_table_order_detail_product FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS bill (
   id serial PRIMARY KEY,
   business_id INT NOT NULL,
   place_id INT NOT NULL,
   place_table_id INT NOT NULL,
   price DECIMAL(12,2) DEFAULT 0,
   created_date BIGINT NOT NULL,
   modified_date BIGINT NOT NULL,
   CONSTRAINT fk_bill_business FOREIGN KEY(business_id) REFERENCES business(id),
   CONSTRAINT fk_bill_place FOREIGN KEY(place_id) REFERENCES place(id),
   CONSTRAINT fk_bill_place_table FOREIGN KEY(place_table_id) REFERENCES place_table(id)
);

CREATE TABLE IF NOT EXISTS bill_detail (
   id serial PRIMARY KEY,
   bill_id INT NOT NULL,
   product_id INT NOT NULL,
   product_name VARCHAR(255) NOT NULL,
   price DECIMAL(12,2) DEFAULT 0,
   amount INT NOT NULL,
   CONSTRAINT fk_bill_detail_bill FOREIGN KEY(bill_id) REFERENCES bill(id),
   CONSTRAINT fk_bill_detail_product FOREIGN KEY(product_id) REFERENCES product(id)
);