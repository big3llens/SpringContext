package ru.geekbrains.lesson2;

import java.util.List;

public interface Cart {
    public void init();
    public void addProduct (int id);
    public List<Product> getCartList();
    public void removeProduct (int id);
}
