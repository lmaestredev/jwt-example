package com.ecommerce.razei.dtos.responses;

import com.ecommerce.razei.models.Product;

public class ProductRespDto {

    private Long id;
    private String name;
    private String code;
    private double price;
    private Integer quantity;
    private String type;
    private String description;

    public ProductRespDto() {
    }

    public ProductRespDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.type = product.getType();
        this.description = product.getDescription();
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
