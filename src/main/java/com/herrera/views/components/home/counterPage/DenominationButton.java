package com.herrera.views.components.home.counterPage;

import java.awt.Font;

import javax.swing.JButton;

import com.herrera.views.components.themes.Themes;

public class DenominationButton extends JButton {

    private int denominationValue = 0;

    public DenominationButton(String valueText, int value) {
        super(valueText);
        this.denominationValue = value;
        setPreferredSize(Themes.Btn_Regular_Dimension);
        setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public int getDenominationValue() {
        return denominationValue;
    }
}
