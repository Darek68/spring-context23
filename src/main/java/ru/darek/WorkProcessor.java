package ru.darek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Scanner;
//@Controller @RestController @Service @Repository
//@Service
@PropertySource("classpath:application.yml")
@Component
public class WorkProcessor {
    private ProductRepository productRepository;
    private Cart cart;
    @Value("${count}")
    public int count;

    public WorkProcessor(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void startWork() {
        System.out.println("Текущаяя корзина: ");
        System.out.println(productRepository.getAll().toString());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ad <№> - добавить продукт в корзину \n rm <№> - удалить продукт из  корзины \n exit");
            System.out.println("Текущая корзина: \n " + cart.toString());
            if (count-- < 0) break;
            String command = scanner.nextLine();
            if (command.startsWith("exit")) break;
            if (command.startsWith("ad")) cart.addToCart(getId(command));
            if (command.startsWith("rm")) cart.removeFromCart(getId(command));
        }
    }

    private Long getId(String command) {
        String[] words = command.trim().split(" ");
        if (words.length < 2) return Long.MAX_VALUE;
        return Long.parseLong(words[1].trim());
    }
}










