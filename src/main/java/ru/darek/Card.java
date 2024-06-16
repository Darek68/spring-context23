package ru.darek;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
//@Controller
@Scope("prototype")
@Component
public class Card {
    private ProductRepository productRepository;
    private List<Product> products;

    public Card() {
        this.productRepository = new ProductRepository();
        this.products = new ArrayList<>();
    }

    public void addToCard(Long id) {
        System.out.println("addToCard " + id);
        Product product = productRepository.getById(id).orElse(null);
        if (product != null) {
            if (products.contains(product)) return;
            products.add(product);
        }
    }

    public void removeFromCard(Long id) {
        Product product = productRepository.getById(id).orElse(null);
        if (product != null) products.remove(product);
    }

    @Override
    public String toString() {
        return "Card{" +
                "products=" + products +
                '}';
    }
}
