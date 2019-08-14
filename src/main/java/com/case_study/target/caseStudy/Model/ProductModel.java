package com.case_study.target.caseStudy.Model;

import com.case_study.target.caseStudy.entity.Product;
import com.case_study.target.caseStudy.utils.Price;

public class ProductModel {
	
	String id;
	Price current_price;
 	String product_desc;
	
 	
	
	public ProductModel() {
		
	}

	public ProductModel(Product product) {
		this.id = product.getPk();
		this.current_price = new Price(product.getCurrentPrice(),product.getCurrencyCode());		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Price getPrice() {
		return current_price;
	}
	public void setPrice(Price current_price) {
		this.current_price = current_price;
	}
	public String getDescription() {
		return product_desc;
	}
	public void setDescription(String product_desc) {
		this.product_desc = product_desc;
	}
	
	
	
	

}
