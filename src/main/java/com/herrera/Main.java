package com.herrera;

import javax.swing.SwingUtilities;

import com.herrera.controllers.LoginController;
import com.herrera.views.components.home.HomeMenu;
import com.herrera.views.components.login.LoginComponent;
import com.herrera.views.tests.OrderTable;
import com.herrera.views.tests.TestingLang;
import com.herrera.views.windows.Frame;

public class Main {
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                LoginController login_controller = new LoginController(new
                LoginComponent("login-component"));
                new Frame("Login", login_controller.getView()).setVisible(true);
                // new Frame("test-home-menu", new HomeMenu("test-home-menu")).setVisible(true);
                // new Frame("test-home-menu", new TestingLang()).setVisible(true);
                // new Frame("test-table", new OrderTable("test-table")).setVisible(true);
            }

        });

    }
}
