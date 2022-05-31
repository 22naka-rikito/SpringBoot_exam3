package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.controller.form.DeleteForm;
import com.example.service.ProductService;

@Controller
public class DeleteController {
	@Autowired
	ProductService productService;
	
	@RequestMapping( value="/deleteResult", params = "delete" )
	public String deleteProduct(@Validated @ModelAttribute("delete") DeleteForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            return "delete";
        }
		if(!productService.deleteProduct(form.getProductId())) {
			model.addAttribute("msg", "a");
			return "delete";
		}
		return "deleteResult";
	}
}