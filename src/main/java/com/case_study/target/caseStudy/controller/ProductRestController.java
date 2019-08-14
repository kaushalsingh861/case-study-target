package com.case_study.target.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.case_study.target.caseStudy.Model.ProductModel;
import com.case_study.target.caseStudy.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products/{id}")
	public ProductModel getProductByPk(@PathVariable Integer id){
		return productService.getById(id.toString());
	}
	
	@GetMapping("/products")
	public List<ProductModel> getProductByPk(){
		return productService.getAll();
	}
	
	@PostMapping("/products")
	public ProductModel newProduct(@RequestBody ProductModel productModel){
		productService.create(productModel);
		return productModel;
	}
	
	@PutMapping("/products")
	public ProductModel updateProduct(@RequestBody ProductModel productModel){
		return productService.update(productModel);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id){
		productService.deleteById(id.toString());		
	}
	
	@GetMapping("/init")
	public List<ProductModel> initialise(){
		return productService.init();
	}
}
