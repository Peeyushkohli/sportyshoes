package com.sportyshoes.controller;


import java.lang.System.Logger;
import java.util.List;
import java.util.Random;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.dto.ResponseOrderDTO;
import com.sportyshoes.dto.OrderDTO;
import com.sportyshoes.entity.Customer;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;
import com.sportyshoes.services.CustomerService;
import com.sportyshoes.services.OrderService;
import com.sportyshoes.services.ProductService;
import com.sportyshoes.util.DateUtil;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@ToString
//@org.springframework.web.bind.annotation.RestController
//@org.springframework.web.bind.annotation.RequestMapping("/api")
@RequestMapping("/api")
@RestController
public class ShoppingCartRestController {

	 private OrderService orderService;
	    private ProductService productService;
	    private CustomerService customerService;


	    public ShoppingCartRestController(OrderService orderService, ProductService productService, CustomerService customerService) {
	        this.orderService = orderService;
	        this.productService = productService;
	        this.customerService = customerService;
	    }

	    private org.jboss.logging.Logger logger = LoggerFactory.logger(ShoppingCartRestController.class);
	    
	    
	    @GetMapping(value="/About")
	    public String home() {
	    	return "This is Sporty Shoes  developed as Rapid App for the prototyping ver 1.0 by Peeyush Kohli" ;
	    }
	    
	    @GetMapping(value = "/getAllProducts")
	    public ResponseEntity<List<Product>> getAllProducts() {

	        List<Product> productList = productService.getAllProducts();

	        return ResponseEntity.ok(productList);
	    }

	    @GetMapping(value = "/getOrder/{orderId}")
	    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {

	        Order order = orderService.getOrderDetail(orderId);
	        return ResponseEntity.ok(order);
	    }


	    @PostMapping("/placeOrder")
	    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
	        logger.info("Request Payload " + orderDTO.toString());
	        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
	        float amount = orderService.getCartAmount(orderDTO.getCartItems());

	        
	     
	        
	        
	        
	        
	        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
	        Integer customerIdFromDb = customerService.isCustomerPresent(customer);
	        if (customerIdFromDb != null) {
	            customer.setId(customerIdFromDb);
	            logger.info("Customer already present in db with id : " + customerIdFromDb);
	        }else{
	            customer = customerService.saveCustomer(customer);
	            logger.info("Customer saved.. with id : " + customer.getId());
	        }
	        Order order = new Order(customerIdFromDb, orderDTO.getOrderDescription(), customer, orderDTO.getCartItems(), null);
	        order = orderService.saveOrder(order);
	        logger.info("Order processed successfully..");

	        responseOrderDTO.setAmount(amount);
	        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
	        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
	        responseOrderDTO.setOrderId(order.getId());
	        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

	        logger.info("test push..");

	        return ResponseEntity.ok(responseOrderDTO);
	    }

	}
	
	

