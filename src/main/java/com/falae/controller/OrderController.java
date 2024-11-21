package com.falae.controller;

import com.falae.model.Order;
import com.falae.model.OrderItem;
import com.falae.model.Product;
import com.falae.model.User;
import com.falae.service.dto.CreateOrderDTO;
import com.falae.service.dto.OrderResponseDTO;
import com.falae.service.repository.OrderRepository;
import com.falae.service.repository.ProductRepository;
import com.falae.service.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid CreateOrderDTO createOrderDTO) {
        User user = userRepository.findById(createOrderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        double totalPrice = 0.0;
        List<OrderItem> orderProducts = new ArrayList<>();

        for (CreateOrderDTO.OrderItemDTO itemDTO : createOrderDTO.getProducts()) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto nao encontrado: " + itemDTO.getProductId()));

            if (itemDTO.getQuantity() <= 0) {
                throw new RuntimeException("Quantidade invalida para o produto: " + product.getName());
            }

            double itemTotal = product.getPrice() * itemDTO.getQuantity();
            totalPrice += itemTotal;

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setTotalPrice(itemTotal);
            orderProducts.add(orderItem);
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        order.setStatus("Pendente");
        order.setCreatedAt(LocalDateTime.now());
        order.setProducts(orderProducts);

        for (OrderItem item : orderProducts) {
            item.setOrder(order);
        }
        Order savedOrder = orderRepository.save(order);

        return ResponseEntity.ok(savedOrder.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista de pedidos nao encontrada"));

        OrderResponseDTO response = new OrderResponseDTO();
        response.setId(order.getId());
        response.setTotalPrice(order.getTotalPrice());
        response.setStatus(order.getStatus());
        response.setCreatedAt(order.getCreatedAt());

        List<OrderResponseDTO.ProductDTO> products = order.getProducts().stream().map(item -> {
            OrderResponseDTO.ProductDTO productDTO = new OrderResponseDTO.ProductDTO();
            productDTO.setName(item.getProduct().getName());
            productDTO.setQuantity(item.getQuantity());
            productDTO.setPrice(item.getProduct().getPrice());
            return productDTO;
        }).toList();

        response.setProducts(products);

        return ResponseEntity.ok(response);
    }

}
