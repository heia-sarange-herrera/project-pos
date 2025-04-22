package com.herrera.views.components;

import javax.swing.JPanel;

public abstract class Components extends JPanel {

    String component_name;

    public Components(String component_name) {
        this.component_name = component_name;
    }

    public String getComponent_name() {
        return component_name;
    }

    public void setComponent_name(String component_name) {
        this.component_name = component_name;
    }

    public String getComponentName() {
        return component_name;
    }
}
