package com.herrera.views.components.home.counterPage.subcategory;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import com.herrera.views.components.Components;
import com.herrera.views.components.reusable.ProductContainer;

public class CategorySubs extends Components {

    List<ProductContainer> productList;

    public CategorySubs(String component_name, List<ProductContainer> productsList) {
        super(component_name);

        // this
        this.productList = productsList;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        // add
        productsList.forEach(products -> {
            add(products);
        });

        
        
    }

    public void addToProduct(ProductContainer product) {
        this.productList.add(product);
    }

    
}
