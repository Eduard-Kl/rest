package hr.assignment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ProductRepository repo;

    @PutMapping(value = "/product", consumes = "application/json")
    public String putProduct(@RequestBody Product product) {

        product.setPrice_usd(ExchangeRate.convertToUSD(product.getPrice_eur()));

        this.repo.save(product);
        return product.toString();
    }

    @GetMapping(value = "/product", produces = "application/json")
    public String getProduct(@RequestParam(value = "code") String code) {
        return "Not yet implemented";
    }

    @DeleteMapping(value = "/product")
    public String deleteProduct() {
        return "Not yet implemented";
    }
}
