package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.controller.form.UpdateForm;
import com.example.service.ProductService;

@Controller
public class UpdateController {
	@Autowired
	ProductService productService;

	@RequestMapping( value="/updateResult", params = "update" )
	public String updateProduct(@Validated @ModelAttribute("update") UpdateForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            return "update";
        }
		if(!productService.updateProduct(form.getProductId(), form.getProductName(), form.getPrice())) {
			model.addAttribute("msg", "a");
			return "update";
		}
		
		return "updateResult";
	}
}