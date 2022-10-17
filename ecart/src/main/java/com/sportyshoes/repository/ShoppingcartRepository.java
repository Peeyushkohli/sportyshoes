package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.entity.Shoppingcart;

public interface ShoppingcartRepository extends JpaRepository<Shoppingcart, Integer> {

}
