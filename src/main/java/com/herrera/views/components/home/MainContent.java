package com.herrera.views.components.home;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.herrera.views.components.Components;
import com.herrera.views.components.home.counterPage.CounterPage;

public class MainContent extends Components {

    CardLayout layout = new CardLayout();
    CounterPage counterPage;
    JPanel managePage, configurePage;

    public MainContent(String component_name) {
        super(component_name);

        // this
        setLayout(layout);

        // components
        counterPage = new CounterPage("counter-page");
        managePage = new JPanel();
        managePage.setBackground(Color.GREEN);
        configurePage = new JPanel();
        configurePage.setBackground(Color.BLUE);

        managePage.add(new JLabel("Manage Page"));
        configurePage.add(new JLabel("Configure Page"));

        add(counterPage, "counterPage");
        add(managePage, "managePage");
        add(configurePage, "configurePage");

    }

    public CounterPage getCounterPage() {
        return this.counterPage;
    }

    public JPanel getManagePage() {
        return this.managePage;
    }

    public JPanel getConfigurePage() {
        return this.configurePage;
    }

    public CardLayout getLayoutUsed() {
        return this.layout;
    }
}
