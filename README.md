PostgreSQL database setup
```sql
CREATE DATABASE rest;
CREATE ROLE rest WITH LOGIN PASSWORD 'tajnasifra';
```

CREATE example
```shell
curl -X POST -H "Content-Type: application/json" -d '{"name": "New product", "price_eur": 5.01, "description": "Awesome product", "is_available": true}' localhost:8080/product
```

READ example
```shell
curl -X GET localhost:8080/product?code=1111
```

UPDATE example
```shell
curl -X PUT ...
```

DELETE example
```shell
curl -X DELETE localhost:8080/product?code=1111
```
