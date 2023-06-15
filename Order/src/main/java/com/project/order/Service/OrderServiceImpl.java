package com.project.order.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.order.Model.Order;
import com.project.order.repo.OrderRepository;



@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
    	Optional<Order> opt=orderRepository.findById(orderId);
    	if(opt.isPresent()) {
			return opt.get();
		}
		else
			return null;
	}
    @Override
    public Order createOrder(Order order) {
        // Perform validation or other business logic
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        // Perform validation or other business logic
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}