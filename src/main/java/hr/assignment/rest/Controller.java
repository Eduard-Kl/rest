package hr.assignment.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PutMapping(value = "/product", consumes = "application/json")
    public String putProduct(@RequestBody Product product) {
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
