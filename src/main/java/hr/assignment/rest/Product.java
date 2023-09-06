package hr.assignment.rest;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String code;
    private String name;
    private BigDecimal price_eur;;
    private BigDecimal price_usd;
    private String description;
    private boolean is_available;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price_eur=" + price_eur +
                ", price_usd=" + price_usd +
                ", description='" + description + '\'' +
                ", is_available=" + is_available +
                '}';
    }
}
