package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer getCustomerByEmailAndName(String email, String name);
	

}
