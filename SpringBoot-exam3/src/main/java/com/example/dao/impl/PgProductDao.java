package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductDao;
import com.example.entity.Product;

@Repository
public class PgProductDao implements ProductDao{
	private static final String FIND_ALL = "SELECT * FROM products";
	private static final String SELECT_BY_PRODUCT_ID = "SELECT * FROM products WHERE product_id = :product_id";
	private static final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM products "
			+ "WHERE product_name = :product_name";
	private static final String SELECT_BY_PRICE = "SELECT * FROM products "
			+ "WHERE price = :price";
	private static final String SELECT_BY_PRODUCT_NAME_AND_PRICE = "SELECT * FROM products "
			+ "WHERE product_name = :product_name AND price = :price";
	private static final String INSERT_PRODUCTS = "INSERT INTO products ("
			+ "product_name, price) "
			+ "values(:product_name, :price)";
	private static final String DELETE_PRODUCTS = "DELETE FROM products WHERE product_id = :product_id";
	private static final String UPDATE_PRODUCTS = "UPDATE products SET product_name = :product_name, "
			+ "price = :price WHERE product_id = :product_id";
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Product> findAll() {
    	String sql = FIND_ALL;
        MapSqlParameterSource param = new MapSqlParameterSource();
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
        return resultList.isEmpty() ? null : resultList;
    }
	
    public Product findById(Integer productId) {
    	String sql = SELECT_BY_PRODUCT_ID;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", productId);
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    public List<Product> findByName(String productName) {
    	String sql = SELECT_BY_PRODUCT_NAME;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_name", productName);
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Product> findByPrice(Integer price) {
    	String sql = SELECT_BY_PRICE;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("price", price);
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
        return resultList.isEmpty() ? null : resultList;
    }
    
    public List<Product> findByNamePrice(String productName, Integer price) {
    	String sql = SELECT_BY_PRODUCT_NAME_AND_PRICE;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_name", productName);
        param.addValue("price", price);
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
        return resultList.isEmpty() ? null : resultList;
    }
    
    public void insertProduct(String productName, Integer price) {
    	String sql = INSERT_PRODUCTS;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_name", productName);
        param.addValue("price", price);
        jdbcTemplate.update(sql, param);
    }
    
    public void deleteProduct(Integer productId) {
    	String sql = DELETE_PRODUCTS;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", productId);
        jdbcTemplate.update(sql, param);
    }
    
    public void updateProduct(Integer productId, String productName, Integer price) {
    	String sql = UPDATE_PRODUCTS;
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("product_id", productId);
        param.addValue("product_name", productName);
        param.addValue("price", price);
        jdbcTemplate.update(sql, param);
    }
}