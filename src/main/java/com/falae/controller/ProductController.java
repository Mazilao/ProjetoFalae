package com.falae.controller;


import com.falae.model.Product;
import com.falae.service.ProductService;
import com.falae.service.dto.ProductDTO;
import com.falae.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        try {
            Product newProduct = new Product(data);
            productRepository.save(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto invalido.");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value="id") Integer id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }
}
