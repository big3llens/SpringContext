package ru.geekbrains.lesson2;

import java.util.List;

public interface Repository {
    public void init();
    public List<Product> getProductList();
    public void add(Product product);
}
