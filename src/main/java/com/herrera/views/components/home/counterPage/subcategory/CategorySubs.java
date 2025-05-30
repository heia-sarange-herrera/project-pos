package com.herrera.views.components.home.counterPage.subcategory;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.herrera.models.OrderContextModel;
import com.herrera.models.Product;
import com.herrera.views.components.Components;
import com.herrera.views.components.home.counterPage.OrderTable;
import com.herrera.views.components.reusable.ProductContainer;

public class CategorySubs extends Components {

    private List<ProductContainer> productList;
    private OrderTable table;
    private OrderContextModel orderContextModel;

    public CategorySubs(String component_name, List<ProductContainer> productsList, OrderTable table,
            OrderContextModel orderContextModel) {
        super(component_name);
        this.table = table;
        this.orderContextModel = orderContextModel;
        // this
        this.productList = productsList;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(getWidth(), getHeight()));
        // prop
        // add
        productsList.forEach(products -> {
            add(products);
            products.handle_product_button(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    table.addRowToTable(
                            new Object[] { products.getProduct_name(), "Php " + products.getProduct_price() });
                    orderContextModel.setTotalOrderPrice(products.getProduct_price());
                    CategorySubs.this.table.setTotalLabel(String.valueOf(orderContextModel.getTotalOrderPrice()));
                    System.out.println("Total Order Price: " + orderContextModel.getTotalOrderPrice());
                }

            });
        });

    }

    public void addToProduct(ProductContainer product) {
        this.productList.add(product);
    }

    public void handle_productListButton(ActionListener e) {
        productList.forEach(buttons -> {
            buttons.handle_product_button(e);
        });
    }

}
