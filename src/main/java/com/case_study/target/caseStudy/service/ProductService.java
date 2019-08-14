package com.case_study.target.caseStudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.case_study.target.caseStudy.Model.ProductModel;
import com.case_study.target.caseStudy.entity.Description;
import com.case_study.target.caseStudy.entity.Product;
import com.case_study.target.caseStudy.exceptionhandling.ProductException;
import com.case_study.target.caseStudy.repository.DescriptionRepository;
import com.case_study.target.caseStudy.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	DescriptionRepository descriptionRepository;
	
	public ProductModel getById(String id){
		Product p = productRepository.findByPk(id);
		ProductModel productModel =  new ProductModel(p);
		productModel.setDescription(descriptionRepository.findByPid(p.getPk()).getDescription());
		
		return productModel;
	}
	
	public List<ProductModel> getAll(){
		List<ProductModel> pml = new ArrayList<ProductModel>();
		List<Product> pl = productRepository.findAll();
		for(Product p: pl){
			ProductModel pm = new ProductModel(p);
			pm.setDescription(descriptionRepository.findByPid(p.getPk()).getDescription());
			pml.add(pm);
		}
		return pml;
	}
	
	public ProductModel create(ProductModel productModel){
		productRepository.save(new Product(productModel.getId(), 
				                               		   productModel.getPrice().getPrice(), 
				                               		   productModel.getPrice().getCurrency_code()));
		descriptionRepository.save(new Description(productModel.getId(),productModel.getDescription()));
		
		return productModel;
	}
	
	public ProductModel update(ProductModel productModel){
		Product p = new Product(productModel.getId(), 
        		   				productModel.getPrice().getPrice(), 
        		   				productModel.getPrice().getCurrency_code());
		Product tempP  = productRepository.findByPk(productModel.getId());
		if(tempP==null){
			throw new ProductException("Product Id Not Found");
		}
		if(!tempP.equals(p)){
			p.setId(tempP.getId());
			productRepository.save(p);
		}
		
		Description d = new Description(productModel.getId(),productModel.getDescription());
		
		Description tempD = descriptionRepository.findByPid(productModel.getId());
		
		if(!tempD.equals(d)||tempD==null){
			if(tempD!=null){
				d.setId(tempD.getId());
			}
			descriptionRepository.save(d);
		}
		
		
		return productModel;
	}
	
	public void deleteById(String id){
				
		Product p = productRepository.findByPk(id);
		Description d = descriptionRepository.findByPid(id);
		
		if(p==null){
				throw new ProductException("Product Id Not Found");
			}
		
		productRepository.delete(p);
		
		if(d!=null)
		descriptionRepository.delete(d);
		
		
	}
	
	public List<ProductModel> init(){

		
		Product[] p = {new Product("15117729",12,"USD"),
		   		  new Product("16483589",13,"USD"),
		   		  new Product("16696652",14,"USD")};
		
		Description[] d = {new Description("15117729", "Shirt"),
						   new Description("16483589", "Pant"),
						   new Description("16696652", "Suit")};
		
		List<Product> ps = new ArrayList<Product>();
		ps.add(p[0]);
		ps.add(p[1]);
		ps.add(p[2]);
		
		List<Description> ds = new ArrayList<Description>();
		ds.add(d[0]);
		ds.add(d[1]);
		ds.add(d[2]);
		
		productRepository.deleteAll();
		productRepository.saveAll(ps);
		
		descriptionRepository.deleteAll();
		descriptionRepository.saveAll(ds);

		return getAll();
	
	}
	
	
}
