package com.karsauyeung.onlineshop.dao;

import com.karsauyeung.onlineshop.dto.ProductRequest;
import com.karsauyeung.onlineshop.model.Product;
import com.karsauyeung.onlineshop.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ProductDaoImp implements ProductDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;



    @Override
    public Product GetProductbyId(Integer id) {
        String sql = "select product_id , product_name ,category, image_url, " +
                "price, stock, description, created_date, " +
                "last_modified_date from product where product_id=:product_id;" ;

        Map<String , Object> map = new HashMap<>() ;
        map.put("product_id" , id) ;
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (productList.size() > 0){
            return productList.get(0) ;
        }
        else {
            return null ;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql ="insert into product (product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date) " +
                "values (:name, :category, :image_url, :price, :stock, :description, " +
                ":created_date, :last_modified_date)\n";



        Map<String , Object> map = new HashMap<>() ;
        map.put("name" , productRequest.getProductName() ) ;
        map.put("category" , productRequest.getCategory().name()) ;
        map.put("image_url", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());


        Date now = new Date();
        map.put("created_date", now);
        map.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder() ;

        namedParameterJdbcTemplate.update(sql , new MapSqlParameterSource(map), keyHolder) ;

        int product_id = keyHolder.getKey().intValue();

        return product_id ;

    }
}
