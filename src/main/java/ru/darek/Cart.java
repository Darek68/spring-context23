package ru.darek;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//@Controller
@Scope("prototype")
@Component
public class Cart {
    private ProductRepository productRepository;
    private List<Product> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new ArrayList<>();
    }

    public void addToCart(Long id) {
        System.out.println("addToCard " + id);
        Product product = productRepository.getById(id).orElse(null);
        if (product != null) {
            if (products.contains(product)) return;
            products.add(product);
        }
    }

//    public void removeFromCart(Long id) {
//        Product product = productRepository.getById(id).orElse(null);
//        if (product != null) products.remove(product);
//    }
    public void removeFromCart(Long id) {
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getId() == id) {
                it.remove();
            }
        }
        Product product = productRepository.getById(id).orElse(null);
        if (product != null) products.remove(product);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
