Simple Java Spring REST service that manages a list of products in a PostgreSQL database. Uses HNB's [API](https://api.hnb.hr/) for currency exchange rate data.

PostgreSQL database setup
```shell
$ sudo -i -u postgres
postgres@local:~$ psql -p 5432
```
```sql
CREATE DATABASE rest;
CREATE ROLE rest WITH LOGIN PASSWORD 'tajnasifra';
GRANT postgres TO rest;

CREATE TABLE product (
    id SERIAL,
    code TEXT PRIMARY KEY,
    name TEXT,
    price_eur NUMERIC,
    price_usd NUMERIC,
    description TEXT,
    is_available BOOLEAN
);
```

CREATE example
```shell
curl -X POST -H "Content-Type: application/json" -d '{"name": "New product", "price_eur": 5.01, "description": "Awesome product", "is_available": true}' localhost:8080/product
```

READ example
```shell
curl -X GET localhost:8080/product?code=9854fe8a7e
```

UPDATE example
```shell
curl -X PUT -H "Content-Type: application/json" -d '{"code": "9854fe8a7e", "name": "New product 2", "price_eur": 6.01, "description": "Awesome product 2", "is_available": true}' localhost:8080/product
```

DELETE example
```shell
curl -X DELETE localhost:8080/product?code=9854fe8a7e
```
