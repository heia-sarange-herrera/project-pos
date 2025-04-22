package com.herrera.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.herrera.views.components.home.HomeMenu;
import com.herrera.views.components.login.LoginComponent;
import com.herrera.views.windows.Frame;

public class LoginController {

    LoginComponent view;
    String user_name;
    char[] password;

    public LoginController(LoginComponent view) {
        this.view = view;

        // add button handlers
        view.getComponent().handleLoginBtn(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                user_name = view.getComponent().getUsernameFieldValue();
                password = view.getComponent().getPasswordFieldValue();
                String password_str = new String(password);

                if (view.getComponent().getUsernameFieldValue() == null
                        || view.getComponent().getUsernameFieldValue().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "cannot be empty, please specify fields", "Invalid", 0);
                } else {
                    if (user_name.equals("root") && password_str.equals("root")) {
                        SwingUtilities.getWindowAncestor(view).dispose();
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {

                                HomeMenu homeMenu = new HomeMenu("home-menu");
                                HomeController homeController = new HomeController(homeMenu);

                                new Frame("Home", homeController.getView()).setVisible(true);
                            }

                        });
                    } else {
                        JOptionPane.showMessageDialog(view, "Invalid Credentials, please try again!", "No Credential",
                                0);
                    }
                }

            }

        });
        // exit button handler
        view.getComponent().handleExitBtn(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you really wish to exit this page?", "Exit", 0);
                if (choice == 0) {
                    SwingUtilities.getWindowAncestor(view).dispose();
                }
            }

        });
    }

    public JPanel getView() {
        return this.view;
    }

}
