package ru.geekbrains.lesson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        UsersCart cart1 = context.getBean("usersCart", UsersCart.class);
        System.out.println(cart1.getCartList());
        cart1.addProduct(2);
        System.out.println(cart1.getCartList());
        UsersCart cart2 = context.getBean("usersCart", UsersCart.class);
        System.out.println(cart2.getCartList());
    }
}

