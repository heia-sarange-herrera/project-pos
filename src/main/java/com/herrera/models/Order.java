package com.herrera.models;

import java.util.List;

import com.herrera.views.components.reusable.ProductContainer;

public class Order {
    
    private List<ProductContainer> productsList;
    
    public List<ProductContainer> getProductsList() {
        return productsList;
    }

    public void addToProductList(ProductContainer product){
        productsList.add(product);
    }

}
