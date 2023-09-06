PostgreSQL database setup:
```sql
CREATE DATABASE rest;

CREATE TABLE product (
    id INTEGER primary key generated always as identity,
    code VARCHAR(10) NOT NULL,
    name TEXT,
    price_eur NUMERIC,
    price_usd NUMERIC,
    description TEXT,
    is_available BOOLEAN
);
```