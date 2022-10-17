package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.Product;
import com.sportyshoes.repository.ProductRepository;
import com.sportyshoes.services.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	
		@Autowired
	ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@RequestBody Product prod){
		Product resp1=service.saveProduct(prod);
		if (resp1!=null) 
		{
			return new ResponseEntity<>(resp1,HttpStatus.CREATED);}
			else 
			{
				
				return new ResponseEntity<>("Error While creating Product",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	
	
	@GetMapping("/list")
	public List<Product> getAll()
	{
		return service.getAllProducts();
	}


}
