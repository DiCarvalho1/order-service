package com.example.order_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente não pode estar em branco")
    private String customerName;

    @NotNull(message = "O valor total não pode ser nulo")
    @Min(value = 1, message = "O valor total deve ser maior que zero")
    private BigDecimal totalAmount;

    private LocalDateTime createdAt;

    @Version
    private Integer version;

    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    public Order(String customerName, BigDecimal totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

