package com.project.order.Service;

import java.util.List;

import com.project.order.Model.Order;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}