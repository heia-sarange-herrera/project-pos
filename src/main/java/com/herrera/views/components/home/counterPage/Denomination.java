package com.herrera.views.components.home.counterPage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.herrera.views.components.Components;

public class Denomination extends Components {

    DenominationButton btn_1, btn_5, btn_10, btn_20, btn_50, btn_100, btn_200, btn_500, btn_1000, btn_clear;
    OtherActionButton btn_senior, btn_pwd, btn_empd, btn_pay;
    JPanel denominationPanel, denomiantionsContainer, otherActionJPanel, labelsContainer;
    JLabel label_total, totalLabelText;

    public Denomination(String component_name) {
        super(component_name);

        // this
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(325, 720));
        // properties
        denomiantionsContainer = new JPanel();
        denomiantionsContainer.setLayout(new BorderLayout());
        btn_1 = new DenominationButton("1",1);
        btn_5 = new DenominationButton("5", 5);
        btn_10 = new DenominationButton("10", 10);
        btn_20 = new DenominationButton("20", 20);
        btn_50 = new DenominationButton("50", 50);
        btn_100 = new DenominationButton("100", 100);
        btn_200 = new DenominationButton("200", 200);
        btn_500 = new DenominationButton("500", 500);
        btn_1000 = new DenominationButton("1000", 1000);
        btn_clear = new DenominationButton("Clear", 0);
        // panel
        denominationPanel = new JPanel();
        labelsContainer = new JPanel();
        labelsContainer.setLayout(new BorderLayout());
        labelsContainer.setPreferredSize(new Dimension(300, 60));
        otherActionJPanel = new JPanel();
        otherActionJPanel.setPreferredSize(new Dimension(300, 200));

        denominationPanel.setLayout(new GridLayout(4, 3, 5, 5));
        denominationPanel.setPreferredSize(new Dimension(300, 720 / 2));
        denominationPanel.add(btn_1);
        denominationPanel.add(btn_5);
        denominationPanel.add(btn_10);
        denominationPanel.add(btn_20);
        denominationPanel.add(btn_50);
        denominationPanel.add(btn_100);
        denominationPanel.add(btn_200);
        denominationPanel.add(btn_500);
        denominationPanel.add(btn_1000);
        denominationPanel.add(btn_clear);

        label_total = new JLabel(String.valueOf(0));
        label_total.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        label_total.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 10));

        totalLabelText = new JLabel("₱");
        totalLabelText.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        totalLabelText.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 0));

        labelsContainer.add(totalLabelText, BorderLayout.WEST);
        labelsContainer.add(label_total, BorderLayout.EAST);

        // otherActionJPanel
        btn_senior = new OtherActionButton("Senior Discount", 20);
        btn_pwd = new OtherActionButton("PWDD", 35);
        btn_empd = new OtherActionButton("EMPD", 20);
        btn_pay = new OtherActionButton("PAY", 1);
        otherActionJPanel.setLayout(new GridLayout(2, 3, 5, 5));
        otherActionJPanel.add(btn_senior);
        otherActionJPanel.add(btn_pwd);
        otherActionJPanel.add(btn_empd);
        otherActionJPanel.add(btn_pay);
        // render
        denomiantionsContainer.add(denominationPanel, BorderLayout.CENTER);
        denomiantionsContainer.add(labelsContainer, BorderLayout.NORTH);
        add(denomiantionsContainer, BorderLayout.CENTER);
        add(otherActionJPanel, BorderLayout.SOUTH);
    }

    public List<DenominationButton> getDenominationButtons() {
        return Arrays.asList(this.btn_1, this.btn_5, this.btn_10, this.btn_20, this.btn_50, this.btn_100, this.btn_200,
                this.btn_500, this.btn_1000, this.btn_clear);
    }

    public List<OtherActionButton> getOtherActionButtons() {
        return Arrays.asList(this.btn_senior, this.btn_pwd, this.btn_empd, this.btn_pay);
    }

    

    public void setLabelTotal(String value) {
        this.label_total.setText(value);
    }
}
