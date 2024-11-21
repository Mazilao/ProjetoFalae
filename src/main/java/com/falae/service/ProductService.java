package com.falae.service;

import com.falae.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

//    public static Optional<Product> getProduct(Integer id) {
//        return productRepository.findById(id);
//    }

//    public SearchProductId searchProduct (Integer productId) {
//        Product product = productRepository.findById(productId).orElseThrow(() ->
//                new ObjectNotFoundException("Usuario nao encontrado! Id: " + productId, Product.class.getName()));
//        return SearchProductId.fromDomain(product);
//    }

}
