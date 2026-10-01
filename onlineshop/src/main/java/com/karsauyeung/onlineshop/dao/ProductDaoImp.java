package com.karsauyeung.onlineshop.dao;

import com.karsauyeung.onlineshop.model.Product;
import com.karsauyeung.onlineshop.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

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
                "last_modified_date from product ;" ;

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

}
