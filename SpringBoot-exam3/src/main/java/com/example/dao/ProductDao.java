package com.example.dao;
import java.util.List;

import com.example.entity.Product;

public interface ProductDao {

	public List<Product> findAll();
    public Product findById(Integer id);
    public List<Product> findByName(String productName);
    public List<Product> findByPrice(Integer price);
    public List<Product> findByNamePrice(String productName, Integer price);
    public void insertProduct(String productName, Integer price);
    public void deleteProduct(Integer productId);
    public void updateProduct(Integer productId, String productName, Integer price);
}