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

CREATE example:
```shell
curl -X PUT -H "Content-Type: application/json" -d '{"code": "h8fer", "name": "New product", "price_eur": 5.01, "description": "Awesome product"}' localhost:8080/product
```

GET example:
```shell
curl -X GET localhost:8080/product?code=1111
```
