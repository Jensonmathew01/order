package com.ust.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ust.project.Model.Order;
import com.ust.project.sevices.OrderService;



@RestController
@RequestMapping("/order")

public class OrderController {
	@Autowired
	   OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeorder")
    public ResponseEntity<Long> placeOrder(@RequestBody Order order) {

        long orderId = orderService.placeOrder(order);
        System.out.println("Order Id: " + orderId);
        return ResponseEntity.ok(orderId);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable long orderId) {

        Order order = orderService.getOrderDetails(orderId);
        return ResponseEntity.ok(order);
    }
    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.getOrderDetails(orderId);
        updatedOrder.setProductId(order.getProductId());
        updatedOrder.setQuantity(order.getQuantity());
        updatedOrder.setOrderDate(order.getOrderDate());
        updatedOrder.setAmount(order.getAmount());

        Order savedOrder = orderService.updateOrder( updatedOrder);
        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }
}
