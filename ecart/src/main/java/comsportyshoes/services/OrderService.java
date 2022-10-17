package comsportyshoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Order;
import com.sportyshoes.repository.OrderRepository;



public class OrderService {

		
			
			
			@Autowired
		    private OrderRepository orderRepository;
			
			public OrderService(OrderRepository  orderRepository) {
			this.orderRepository=orderRepository;
			}

		    public List<Order> getAllOrders() {
		        return this.orderRepository.findAll();
		    }
	}
			
		

