package com.project.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.order.Model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
