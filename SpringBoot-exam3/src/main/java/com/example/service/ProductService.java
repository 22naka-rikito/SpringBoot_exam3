package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

	public List<Product> findAll();
    public Product findById(Integer productid);
    public List<Product> findByName(String productName);
    public List<Product> findByPrice(Integer price);
    public List<Product> findByNamePrice(String productName, Integer price);
    public void insertProduct(String productName, Integer price);
}