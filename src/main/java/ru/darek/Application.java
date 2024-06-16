package ru.darek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        WorkProcessor workProcessor = context.getBean(WorkProcessor.class);
     //   WorkProcessor workProcessor = new WorkProcessor(new ProductRepository(),new Card());

        workProcessor.startWork();
    }
}
/**
 * меется класс Product (id, название, цена). Товары хранятся в бине ProductRepository,
 * в виде List, при старте приложения в него необходимо добавить 10 любых товаров.
 * ProductRepository должен позволять получить весь список или один товар по id.
 * Создаем бин Cart, в который можно добавлять и удалять товары по id из репозитория.
 * Написать консольное приложение, позволяющее управлять корзиной.
 * При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */