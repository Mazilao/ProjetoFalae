package com.falae.controller;


import com.falae.service.dto.ProductDTO;
import com.falae.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody ProductDTO data){

        System.out.println(data);
        return ResponseEntity.ok().build();

    }
}
