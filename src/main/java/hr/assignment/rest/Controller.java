package hr.assignment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private ProductRepository repo;

    @PostMapping(value = "/product", consumes = "application/json")
    public String createProduct(@RequestBody Product product) {

        product.setPrice_usd(ExchangeRate.convertToUSD(product.getPrice_eur()));
        product.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 10));

        this.repo.save(product);
        return product.toString();
    }

    @GetMapping(value = "/product", produces = "application/json")
    public String readProduct(@RequestParam(value = "code") String code) {

        return this.repo.findById(code).toString();
    }

    @PutMapping(value = "/product", consumes = "application/json")
    public String updateProduct(@RequestBody Product product) {

        Product fromDatabase = this.repo.findById(product.getCode()).orElse(new Product());

        fromDatabase.setName(product.getName());
        fromDatabase.setPrice_eur(product.getPrice_eur());
        fromDatabase.setPrice_usd(product.getPrice_usd());
        fromDatabase.setDescription(product.getDescription());
        fromDatabase.setIs_available(product.isIs_available());

        this.repo.save(fromDatabase);
        return fromDatabase.toString();
    }

    @DeleteMapping(value = "/product")
    public void deleteProduct(@RequestParam(value = "code") String code) {

        this.repo.deleteById(code);
    }
}
