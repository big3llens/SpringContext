package ru.geekbrains.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class UsersCart implements Cart{
    private ProductRepository repository;
    private List<Product> cartList;

    @Autowired
    public UsersCart(ProductRepository repository) {
        this.repository = repository;
        cartList = new ArrayList<>();
        Collections.unmodifiableList(cartList);
    }

    @Override
    @PostConstruct
    public void init(){
        for (int i = 0; i < 5; i++) {
            int number = (int)(Math.random()*5);
            for (Product p: repository.getProductList()) {
                if (number == p.getId()) cartList.add(p);
            }
        }
    }

    @Override
    public void addProduct (int id){
        for (Product p: repository.getProductList()) {
            if (id == p.getId()) cartList.add(p);
        }
    }

    @Override
    public List<Product> getCartList() {
        return cartList;
    }

    @Override
    public void removeProduct (int id){
        for (Product p: repository.getProductList()) {
            if (id == p.getId()) cartList.remove(p);
        }
    }
}
