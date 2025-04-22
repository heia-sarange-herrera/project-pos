package com.herrera.models;

import java.util.List;

import com.herrera.views.components.reusable.ProductContainer;

public class Order {
    
    List<ProductContainer> orderList;
    private int order_number;


    public void addToOrderList(ProductContainer product){
        orderList.add(product);
    }

}
