package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.controller.form.TopForm;
import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class TopController{
	@Autowired
	ProductService productService;
	
	@RequestMapping({"/top" })
    public String top(@ModelAttribute("top") TopForm form, Model model) {
        return "top";
    }
	
	@RequestMapping({"/searchResult" })
    public String searchResult(@ModelAttribute("top") TopForm form, Model model) {
		Product product = productService.findById(form.getProductId());
        model.addAttribute("product", product);
        return "searchResult";
    }
}