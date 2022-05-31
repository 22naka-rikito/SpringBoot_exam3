package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.controller.form.TopForm;
import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class TopController {
	@Autowired
	ProductService productService;

	@RequestMapping({ "/top" })
	public String top(@ModelAttribute("top") TopForm form, Model model) {
		return "top";
	}

	@RequestMapping( value="/searchResult", params = "find" )
	public String searchResult(@ModelAttribute("top") TopForm form, Model model) {
		List<Product> list;
		if (!"".equals(form.getProductName()) && null != form.getPrice()) {
			list = productService.findByNamePrice(form.getProductName(), form.getPrice());
		} else if (!"".equals(form.getProductName())) {
			list = productService.findByName(form.getProductName());
		} else if (null != form.getPrice()) {
			list = productService.findByPrice(form.getPrice());
		} else {
			list = productService.findAll();
		}
		model.addAttribute("list", list);
		return "searchResult";
	}
	
	@RequestMapping( value="/searchResult", params = "insert" )
	public String insertProduct(@ModelAttribute("top") TopForm form, Model model) {
		productService.insertProduct(form.getProductName(), form.getPrice());
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "insertResult";
	}
}