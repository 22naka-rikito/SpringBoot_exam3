package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
		if(list != null) {
			model.addAttribute("list", list);
			return "searchResult";
		}else {
			model.addAttribute("msg", "a");
			return "top";
		}
		
	}
	
	@RequestMapping( value="/searchResult", params = "insert" )
	public String insertProduct(@Validated @ModelAttribute("top") TopForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            return "top";
        }
		System.out.println("2");
		productService.insertProduct(form.getProductName(), form.getPrice());
		System.out.println("3");
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "insertResult";
	}
}