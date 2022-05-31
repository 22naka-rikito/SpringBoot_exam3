package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDao;
import com.example.entity.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    
    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }
    
    public List<Product> findByName(String productName){
    	return productDao.findByName(productName);
    }
    
    public List<Product> findByPrice(Integer price){
    	System.out.println(price);
    	return productDao.findByPrice(price);
    }
    
    public List<Product> findByNamePrice(String productName, Integer price){
    	return productDao.findByNamePrice(productName,price);
    }
    
    public void insertProduct(String productName, Integer price) {
    	productDao.insertProduct(productName, price);
    }
}