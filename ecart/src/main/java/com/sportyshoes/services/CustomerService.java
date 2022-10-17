package com.sportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportyshoes.entity.Customer;
import com.sportyshoes.repository.CustomerRepository;


@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(Customer customer){
        Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(),customer.getName());
        return customer1!=null ? customer1.getId(): null ;
    }

    public List<Customer> getAllCustomersList() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
    }	



    public Customer updateCustomer(Customer newData, int Id) {
		// TODO Auto-generated method stub
		if (customerRepository.findById(Id).isPresent()) {
			Customer oldData=customerRepository.findById(Id).get();
			oldData.setName(newData.getName());
			oldData.setEmail(newData.getEmail());
						return customerRepository.save(oldData);
		}
			else 
			{
				return null;
			}
    }
		
		public boolean deletCustomer(int id) {
			// TODO Auto-generated method stub
			if (customerRepository.findById(id).isPresent()) {
				customerRepository.deleteById(id);
				return true;
						}
			else 
				return false;

    }
    }
		