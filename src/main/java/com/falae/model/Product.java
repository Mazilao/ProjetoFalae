package com.falae.model;

import com.falae.service.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;
    @NotNull
    private double price;
    private String category;
    private String description;

    public Product(ProductDTO productDTO){
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.category = productDTO.getCategory();
        this.description = productDTO.getDescription();
    }
}
