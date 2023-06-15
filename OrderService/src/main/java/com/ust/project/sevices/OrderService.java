package com.ust.project.sevices;

import org.springframework.stereotype.Service;

import com.ust.project.Model.Order;




@Service
public interface OrderService {
    long placeOrder(Order order);

    Order getOrderDetails(long orderId);
    Order updateOrder(Order order);
}