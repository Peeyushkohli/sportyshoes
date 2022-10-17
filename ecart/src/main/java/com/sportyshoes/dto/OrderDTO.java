package com.sportyshoes.dto;

import java.util.List;

import com.sportyshoes.entity.Shoppingcart;



public class OrderDTO {
	
	
	
	    private String orderDescription;
	    private List<Shoppingcart> cartItems;
	    private String customerEmail;
	    private String customerName;

	    public OrderDTO() {
	    }

	    public OrderDTO(String orderDescription, List<Shoppingcart> cartItems, String customerEmail, String customerName) {
	        this.orderDescription = orderDescription;
	        this.cartItems = cartItems;
	        this.customerEmail = customerEmail;
	        this.customerName = customerName;
	    }

	    public String getOrderDescription() {
	        return orderDescription;
	    }

	    public void setOrderDescription(String orderDescription) {
	        this.orderDescription = orderDescription;
	    }

	    public List<Shoppingcart> getCartItems() {
	        return cartItems;
	    }

	    public void setCartItems(List<Shoppingcart> cartItems) {
	        this.cartItems = cartItems;
	    }

	    public String getCustomerEmail() {
	        return customerEmail;
	    }

	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    @Override
	    public String toString() {
	        return "OrderDTO{" +
	                "orderDescription='" + orderDescription + '\'' +
	                ", cartItems=" + cartItems +
	                ", customerEmail='" + customerEmail + '\'' +
	                ", customerName='" + customerName + '\'' +
	                '}';
	    }


}
