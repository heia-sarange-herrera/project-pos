package com.herrera.views.components.home;

import java.awt.BorderLayout;
import java.awt.Dimension;

import com.herrera.views.components.Components;

public class HomeMenu extends Components {

    SideMenu sideMenu;
    MainContent mainContent;

    public HomeMenu(String component_name) {
        super(component_name);

        // this
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1080, 720));
        // components
        sideMenu = new SideMenu("side-menu");
        mainContent = new MainContent("main-menu");
        // other components
        // add(sideMenu, BorderLayout.WEST);
        add(mainContent, BorderLayout.CENTER);
    }

    public SideMenu getSideMenu() {
        return this.sideMenu;
    }

    public MainContent getMainContent() {
        return this.mainContent;
    }

}
