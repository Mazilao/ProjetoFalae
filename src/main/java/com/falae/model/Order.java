package com.falae.model;


import com.falae.service.dto.OrderDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @NotNull
    private double totalPrice;

    @NotNull
    private String status;

    @NotNull
    private LocalDateTime createdAt;

    public Order(OrderDTO orderDTO, User user) {
        this.user = user;
        this.totalPrice = orderDTO.getTotalPrice();
        this.status = orderDTO.getStatus();
        this.createdAt = orderDTO.getCreatedAt() != null ? orderDTO.getCreatedAt() : LocalDateTime.now();
    }


}
