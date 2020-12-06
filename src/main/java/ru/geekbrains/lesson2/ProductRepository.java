package ru.geekbrains.lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository implements Repository {
    private List<Product> productList;

    public ProductRepository(){
        productList = new ArrayList<>();
        Collections.unmodifiableList(productList);
    }

    @Override
    @PostConstruct
    public void init(){
        productList.add(new Product(1, "Apple", 40));
        productList.add(new Product(2, "Orange", 55));
        productList.add(new Product(3, "Pasta", 45));
        productList.add(new Product(4, "Milk", 60));
        productList.add(new Product(5, "Meat", 90));
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public void add(Product product){
        productList.add(product);
    }
}
