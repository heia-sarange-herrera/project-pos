package com.herrera.views.components.reusable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.herrera.views.components.Components;

public class ProductCategoryContainer extends Components {
    private JLabel product_label;

    public ProductCategoryContainer(String component_name, String product_category_name) {
        super(component_name);

        // this
        setBorder(new LineBorder(Color.BLACK, 1));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 300));
        this.product_label = new JLabel(product_category_name);
        this.product_label.setFont(new Font("Arial", Font.BOLD, 14));
        this.product_label.setHorizontalAlignment(JLabel.CENTER);

        // north
        add(product_label, BorderLayout.CENTER);
        
    }

    
    public void handle_click(MouseAdapter clickEvent){
        this.addMouseListener(clickEvent);
    }
}
