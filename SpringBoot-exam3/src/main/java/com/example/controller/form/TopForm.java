package com.example.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TopForm {
//    private Integer productId;
	@NotBlank
    private String productName;
	
	@NotNull
	private Integer price;

    public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

}