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

    public Product(int id, String code, String name, BigDecimal price_eur, BigDecimal price_usd, String description, boolean is_available) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price_eur = price_eur;
        this.price_usd = price_usd;
        this.description = description;
        this.is_available = is_available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(BigDecimal price_eur) {
        this.price_eur = price_eur;
    }

    public BigDecimal getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(BigDecimal price_usd) {
        this.price_usd = price_usd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price_eur=" + price_eur +
                ", price_usd=" + price_usd +
                ", description='" + description + '\'' +
                ", is_available=" + is_available +
                '}';
    }
}
