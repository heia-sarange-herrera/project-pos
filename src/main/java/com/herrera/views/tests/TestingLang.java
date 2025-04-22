package com.herrera.views.tests;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TestingLang extends JPanel {

    CardLayout layout = new CardLayout();
    JPanel card_1, card_2;
    JButton btn_1, btn_2;

    public TestingLang() {

        card_1 = new JPanel();
        card_2 = new JPanel();
        btn_1 = new JButton("Next ->");
        btn_2 = new JButton("Prev <-");

        setLayout(layout);
        setPreferredSize(new Dimension(1080, 720));

        card_1.setBackground(Color.BLUE);
        card_2.setBackground(Color.RED);

        card_1.add(btn_1);
        card_2.add(btn_2);

        add(card_1, "card_1");
        add(card_2, "card_2");

        btn_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                layout.show(TestingLang.this, "card_2");
            }

        });
        btn_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                layout.show(TestingLang.this, "card_1");
            }

        });

    }

}
