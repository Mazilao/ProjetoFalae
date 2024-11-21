package com.falae.service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private String category;
    private String description;

}
