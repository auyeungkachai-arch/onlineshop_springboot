package com.karsauyeung.onlineshop.controller;

import com.karsauyeung.onlineshop.dto.ProductRequest;
import com.karsauyeung.onlineshop.model.Product;
import com.karsauyeung.onlineshop.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService ;

    @GetMapping("/products/{product_id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer product_id){
        Product product =  productService.get_product_by_id(product_id) ;
        if (product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
         Integer product_id = productService.createProduct(productRequest) ;

         Product product = productService.get_product_by_id(product_id) ;

        System.out.println(product_id);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);


    }
}
