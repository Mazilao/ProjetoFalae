package com.falae.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDTO {

    private  Integer userId;
    private List<OrderItemDTO > products;

    @Data
    public static class OrderItemDTO {
        private Integer productId;
        private Integer quantity;
    }

}
