package com.karsauyeung.onlineshop.service;

import com.karsauyeung.onlineshop.dto.ProductRequest;
import com.karsauyeung.onlineshop.model.Product;

public interface ProductService {
    public Product get_product_by_id(Integer id ) ;

    public Integer createProduct(ProductRequest productRequest) ;
    }
