package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return orderRepository.findById(id).map(existingOrder -> {
            // Garante que estamos comparando a versão correta
            if (!existingOrder.getVersion().equals(updatedOrder.getVersion())) {
                return ResponseEntity.status(409).body("Erro de concorrência: O pedido foi modificado por outro usuário.");
            }

            // Atualiza os dados
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());

            try {
                Order savedOrder = orderRepository.save(existingOrder);
                return ResponseEntity.ok(savedOrder);
            } catch (Exception e) {
                return ResponseEntity.status(409).body("Erro ao salvar o pedido.");
            }
        }).orElse(ResponseEntity.notFound().build());
    }

}
