package com.spring.service;

import com.spring.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    static List<ProductModel> listProduct = new ArrayList<>();

    static {
        for (int i = 0; i < 10; ++i) {
            listProduct.add(
                    ProductModel.builder().name("HungDz " + i).price(i).id(i).build()
            );
        }
    }

    public List<ProductModel> findAll() {
        return listProduct;
    }

    public ProductModel findById(Long id) {
        ProductModel product = null;
        for (int i = 0; i < listProduct.size(); ++i) {
            if (listProduct.get(i).getId().longValue() == id.longValue()){
                product = listProduct.get(i);
                break;
            }
        }
        return product;
    }
}
