package com.falae.service.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Integer userId;
    private double totalPrice;
    private String status;
    private LocalDateTime createdAt;
}
