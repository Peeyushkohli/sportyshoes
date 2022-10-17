package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.Customer;
import com.sportyshoes.services.CustomerService;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	
	
		
		
		@Autowired
		CustomerService service;
		
		
		@PostMapping("")
		public ResponseEntity<Object> saveCustomer(@RequestBody Customer cust){
			Customer resp=service.saveCustomer(cust);
			if (resp!=null) 
			{
				return new ResponseEntity<>(resp,HttpStatus.CREATED);}
				else 
				{
					
					return new ResponseEntity<>("Error While creating Customer",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}

		
		@GetMapping("/list")
		public List<Customer> getAll(){
			return service.getAllCustomersList();
		}

		
		@PutMapping("/update/{id}")
		public  ResponseEntity<Object> updateCustomer(@RequestBody Customer c,@PathVariable int id)
		
		{
			Customer resp1=service.updateCustomer(c,id);
			if (resp1!=null) 
			{
				return new ResponseEntity<>(resp1,HttpStatus.FOUND);}
				else 
				{
					
					return new ResponseEntity<>("Error While updating Customer",HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		
			@DeleteMapping("/del/{id}")
			public  ResponseEntity<Object> deleteCustomer(@PathVariable int id){
				if (service.deletCustomer(id)) {
					
					return new ResponseEntity<>("User Deleted successfully",HttpStatus.OK);}
			else
			{
					
					return new ResponseEntity<>("Error While deleting  Customer",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			}
		}



