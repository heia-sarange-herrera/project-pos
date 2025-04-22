package com.herrera.views.components.login.sub;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.herrera.views.components.Components;
import com.herrera.views.components.themes.Themes;

public class FormComponent extends Components {

    JLabel usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton login_btn, exit_btn;

    public FormComponent(String component_name) {
        // base class
        super(component_name);

        // this
        setLayout(new GridBagLayout());

        // constraint
        GridBagConstraints gbc = new GridBagConstraints();

        // x0, y0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameLabel = new JLabel("username");
        add(usernameLabel, gbc);

        // x0, y1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField();
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setPreferredSize(Themes.Btn_Regular_Dimension);
        add(usernameField, gbc);

        // x0, y2
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordLabel = new JLabel("password");
        add(passwordLabel, gbc);

        // x0, y3
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordField.setPreferredSize(Themes.Btn_Regular_Dimension);
        add(passwordField, gbc);

        // insets
        gbc.insets = new Insets(10, 0, 0, 0);

        // x0, y4
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        login_btn = new JButton("Login");
        login_btn.setPreferredSize(Themes.Btn_Regular_Dimension);
        login_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(login_btn, gbc);

        // insets
        gbc.insets = new Insets(5, 0, 0, 0);

        // x0, y5
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        exit_btn = new JButton("Exit");
        exit_btn.setPreferredSize(Themes.Btn_Regular_Dimension);
        exit_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(exit_btn, gbc);

    }

    public String getUsernameFieldValue() {
        return this.usernameField.getText();
    }

    public char[] getPasswordFieldValue() {
        return this.passwordField.getPassword();
    }

    public void handleLoginBtn(ActionListener e) {
        this.login_btn.addActionListener(e);
    }

    public void handleExitBtn(ActionListener e) {
        this.exit_btn.addActionListener(e);
    }

    public static FormComponent createForm(String component_name) {
        return new FormComponent(component_name);
    }

}
