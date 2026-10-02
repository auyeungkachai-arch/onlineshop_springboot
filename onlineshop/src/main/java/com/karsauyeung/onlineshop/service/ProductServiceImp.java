package com.karsauyeung.onlineshop.service;

import com.karsauyeung.onlineshop.dao.ProductDao;
import com.karsauyeung.onlineshop.dto.ProductRequest;
import com.karsauyeung.onlineshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductDao productDao ;

    @Override
    public Product get_product_by_id(Integer id) {
        return productDao.GetProductbyId(id);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
