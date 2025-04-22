package com.herrera.views.components.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.herrera.views.components.Components;
import com.herrera.views.components.login.sub.FormComponent;
import com.herrera.views.components.themes.Themes;

public class LoginComponent extends Components {

    FormComponent form_panel;

    public LoginComponent(String component_name) {
        // base class
        super(component_name);

        // this
        setLayout(new GridBagLayout());
        setPreferredSize(Themes.Container_Regular_Dimension);

        // constraint
        GridBagConstraints gbc = new GridBagConstraints();

        // x0,y0
        gbc.gridx = 0;
        gbc.gridy = 0;
        form_panel = FormComponent.createForm("login-form-panel");
        add(form_panel, gbc);

    }

    public FormComponent getComponent() {
        return this.form_panel;
    }

}
