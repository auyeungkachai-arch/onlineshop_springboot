package com.karsauyeung.onlineshop.dao;

import com.karsauyeung.onlineshop.dto.ProductRequest;
import com.karsauyeung.onlineshop.model.Product;

public interface ProductDao {
    public Product GetProductbyId(Integer Id) ;

    public Integer createProduct(ProductRequest productRequest);
}
