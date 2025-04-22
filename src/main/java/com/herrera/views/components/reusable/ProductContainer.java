package com.herrera.views.components.reusable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.herrera.views.components.Components;
import com.herrera.views.components.themes.Themes;

public class ProductContainer extends Components {

    private JLabel product_label;
    private JButton product_btn;
    private double product_price;
    private String product_name;

    public ProductContainer(String component_name, String product_name, double product_price) {
        super(component_name);

        // this
        this.product_price = product_price;
        this.product_name = product_name;
        setBorder(new LineBorder(Color.BLACK, 1));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 300));
        this.product_label = new JLabel(product_name);
        product_label.setFont(new Font("Arail", Font.BOLD, 18));
        product_label.setHorizontalAlignment(JLabel.CENTER);
        this.product_btn = new JButton("Php " + String.valueOf(product_price));
        this.product_btn.setPreferredSize(Themes.Btn_Regular_Dimension);

        // des
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseEntered(e);
                setBackground(Color.decode("#FAF0E6"));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseExited(e);
                setBackground(Color.WHITE);

            }
        });

        // north
        add(product_label, BorderLayout.CENTER);
        add(this.product_btn, BorderLayout.SOUTH);

    }

    public void handle_product_button(ActionListener e) {
        this.product_btn.addActionListener(e);
    }

    public double getProduct_price() {
        return product_price;
    }

    public String getProduct_name() {
        return product_name;
    }
}
