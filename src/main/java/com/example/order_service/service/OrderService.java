package com.example.order_service.service;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public Order createOrder(Order order) {
        if (isDuplicateOrder(order)) {
            throw new IllegalArgumentException("Pedido duplicado! Já existe um pedido com o mesmo nome de cliente e valor total.");
        }
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private boolean isDuplicateOrder(Order order) {
        return orderRepository.findByCustomerNameAndTotalAmount(order.getCustomerName(), order.getTotalAmount()).isPresent();
    }
}
