package com.sportyshoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Shoppingcart;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;
// com.sportyshoes.entity.Shoppingcart;
import com.sportyshoes.repository.OrderRepository;
import com.sportyshoes.repository.ProductRepository;

//import com.sportyshoes.repository.ShoppingCart;


@Service
public class OrderService {

	
@Autowired
    private OrderRepository orderRepository;
@Autowired
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(int orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public <ShoppingCart> float getCartAmount(List<ShoppingCart> shoppingCartList) {

        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList) {

            int productId = ((Shoppingcart) cart).getProductId();
            Optional<Product> product = productRepository.findById(productId);
            if (product.isPresent()) {
                Product product1 = product.get();
                if (product1.getAvailablequantity() < ((Shoppingcart) cart).getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getAvailablequantity();
                    ((Shoppingcart) cart).setQuantity(product1.getAvailablequantity());
                } else {
                    singleCartAmount = ((Shoppingcart) cart).getQuantity() * product1.getPrice();
                    availableQuantity = product1.getAvailablequantity() - ((Shoppingcart) cart).getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setAvailablequantity(availableQuantity);
                availableQuantity=0;
                ((Shoppingcart) cart).setProductName(product1.getProductname());
                ((Shoppingcart) cart).setAmount(singleCartAmount);
                productRepository.save(product1);
            }
        }
        return totalCartAmount;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
}
    
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
}
}