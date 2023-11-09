package com.ecommerce.razei.controllers;

import com.ecommerce.razei.dtos.responses.ProductRespDto;
import com.ecommerce.razei.models.Product;
import com.ecommerce.razei.services.ProductService;
import com.ecommerce.razei.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(Util.makeDTO("Products", productService.getProducts().stream().map(ProductRespDto::new).collect(Collectors.toList())), HttpStatus.OK);
    }
}
