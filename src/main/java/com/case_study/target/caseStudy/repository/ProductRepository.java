package com.case_study.target.caseStudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.case_study.target.caseStudy.entity.Product;


public interface ProductRepository extends MongoRepository<Product, String>{
		
	public Product findByPk(String pk);
	
}
