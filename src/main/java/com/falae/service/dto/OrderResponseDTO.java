package com.falae.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDTO {
    private Integer id;
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt; // Certifique-se de que este campo existe

    private List<ProductDTO> products;

    @Data
    public static class ProductDTO {
        private String name;
        private Integer quantity;
        private Double price;
    }
}
