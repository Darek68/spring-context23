package ru.darek;

import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
// , DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, Experiment
@Component
public class ProductRepository implements InitializingBean{
    private List<Product> products;

    {
        products = Arrays.asList(
                new Product(0L, "milk", 5.46),
                new Product(1L, "coffee", 8.5),
                new Product(2L, "water", 1.16),
                new Product(3L, "eggs", 2.44),
                new Product(4L, "bread", 1.80),
                new Product(5L, "potato", 1.90),
                new Product(6L, "cabbage", 2.14),
                new Product(7L, "pork", 8.87),
                new Product(8L, "orange", 3.52),
                new Product(9L, "fish", 7.33));
    }

    public Optional<Product> getById(Long id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Product> getAll() {
        return products;
    }
    @PostConstruct
    public void postConstructInit() {
        this.products = Arrays.asList(
                new Product(0L, "milk", 5.46),
                new Product(1L, "coffee", 8.5),
                new Product(2L, "water", 1.16),
                new Product(3L, "eggs", 2.44),
                new Product(4L, "bread", 1.80),
                new Product(5L, "potato", 1.90),
                new Product(6L, "cabbage", 2.14),
                new Product(7L, "pork", 8.87),
                new Product(8L, "orange", 3.52),
                new Product(9L, "fish", 7.33));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.products = Arrays.asList(
                new Product(0L, "milk", 5.46),
                new Product(1L, "coffee", 8.5),
                new Product(2L, "water", 1.16),
                new Product(3L, "eggs", 2.44),
                new Product(4L, "bread", 1.80),
                new Product(5L, "potato", 1.90),
                new Product(6L, "cabbage", 2.14),
                new Product(7L, "pork", 8.87),
                new Product(8L, "orange", 3.52),
                new Product(9L, "fish", 7.33));
    }

    //  public Long getNextId() { return products.stream().mapToLong(p -> p.getId()).max().orElse(0L) + 1L; }
}
