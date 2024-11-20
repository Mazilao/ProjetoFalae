package com.falae.service.dto;

import com.falae.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private double price;
    private String category;
    private String description;

    public ProductDTO(Integer id, String name, double price, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static ProductDTO fromDomain(Product product) {

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .description(product.getDescription())
                .build();

    }
}
