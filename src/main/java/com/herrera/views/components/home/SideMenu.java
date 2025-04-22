package com.herrera.views.components.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.herrera.views.components.Components;
import com.herrera.views.components.themes.Themes;

public class SideMenu extends Components {
    // this properties

    JButton counter_button, manage_button, configure_button;

    public SideMenu(String component_name) {
        super(component_name);

        // this
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(270, 720));
        setBackground(Color.GRAY);

        // constraint
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 0, 0);
        // x0,y0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        counter_button = new JButton("Counter");
        counter_button.setFont(new Font("Segou UI", Font.BOLD, 14));
        counter_button.setPreferredSize(Themes.Btn_Regular_Dimension);
        add(counter_button, gbc);

        // x0,y1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        manage_button = new JButton("Manage");
        manage_button.setFont(new Font("Segou UI", Font.BOLD, 14));
        manage_button.setPreferredSize(Themes.Btn_Regular_Dimension);
        add(manage_button, gbc);

        // x0,y2
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        configure_button = new JButton("Configure");
        configure_button.setFont(new Font("Segou UI", Font.BOLD, 14));
        configure_button.setPreferredSize(Themes.Btn_Regular_Dimension);
        add(configure_button, gbc);

    }

    public void handle_counter_button(ActionListener e) {
        counter_button.addActionListener(e);
    }

    public void handle_manage_button(ActionListener e) {
        manage_button.addActionListener(e);
    }

    public void handle_configure_button(ActionListener e) {
        configure_button.addActionListener(e);
    }

}