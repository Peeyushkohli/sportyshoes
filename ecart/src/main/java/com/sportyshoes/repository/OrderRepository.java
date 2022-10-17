package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.entity.Order;


public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	List<Order> findAll = null;


}
