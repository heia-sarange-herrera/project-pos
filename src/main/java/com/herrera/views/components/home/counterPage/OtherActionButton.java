package com.herrera.views.components.home.counterPage;

import java.awt.Color;

import javax.swing.JButton;

import com.herrera.views.components.themes.Themes;

public class OtherActionButton extends JButton {

    private String button_name;

    private double discountPercent;

    public OtherActionButton(String buttonName, int discountPercent) {
        super(buttonName);

        this.button_name = buttonName;
        this.discountPercent = discountPercent;

        setPreferredSize(Themes.Btn_Regular_Dimension);
        setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        if (buttonName.equalsIgnoreCase("Pay")) {
            setForeground(Color.WHITE);
            setBackground(Color.GREEN);
        }
    }

    public double getDiscountPercent() {
        return this.discountPercent / 100;
    }

    public String getButton_name() {
        return button_name;
    }

}
