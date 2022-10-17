package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAll = null;

	 


}
