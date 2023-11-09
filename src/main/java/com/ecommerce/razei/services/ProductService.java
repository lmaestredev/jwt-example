package com.ecommerce.razei.services;

import com.ecommerce.razei.models.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface ProductService{
    public abstract List<Product> getProducts();
    public abstract void saveProduct(Product product);

}
