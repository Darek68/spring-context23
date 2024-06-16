package ru.darek;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Controller

public class Product {
    private Long id;
    private String title;
    private Double price;

    public Product(Long id,String title, Double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
