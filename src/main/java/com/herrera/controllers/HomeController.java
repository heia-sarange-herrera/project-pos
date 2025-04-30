package com.herrera.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.herrera.models.OrderData;
import com.herrera.views.components.home.HomeMenu;
import com.herrera.views.components.home.counterPage.DenominationButton;
import com.herrera.views.components.home.counterPage.OtherActionButton;

public class HomeController {

    HomeMenu view;
    OrderData order;

    public HomeController(HomeMenu view) {
        this.view = view;
        order = new OrderData();
        view.getSideMenu().handle_counter_button(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMainContent().getLayoutUsed().show(view.getMainContent(), "counterPage");
            }

        });

        view.getSideMenu().handle_manage_button(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMainContent().getLayoutUsed().show(view.getMainContent(), "managePage");
            }

        });

        view.getSideMenu().handle_configure_button(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMainContent().getLayoutUsed().show(view.getMainContent(), "configurePage");
            }

        });

        view.getMainContent().getCounterPage().handleBtnMenu(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMainContent().getCounterPage().getLayoutUsed().show(
                        view.getMainContent().getCounterPage().getCounterContainer(),
                        "menuContainer");
            }
        });

        view.getMainContent().getCounterPage().handleBtnOrder(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.getMainContent().getCounterPage().getLayoutUsed().show(
                        view.getMainContent().getCounterPage().getCounterContainer(),
                        "orderContainer");
            }
        });

        List<DenominationButton> denominations_btns = view.getMainContent().getCounterPage().getDenomination()
                .getDenominationButtons();

        denominations_btns.forEach(button -> {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (order.getTotal() < 0) {
                        JOptionPane.showMessageDialog(view.getMainContent(), "Total cannot be negative", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        order.setTotal(0);
                        ;

                    } else {
                        if (button.getDenominationValue() == 0) {
                            order.setTotal(0);
                            view.getMainContent().getCounterPage().getDenomination().setLabelTotal("0");
                        } else {

                            order.setTotal(order.getTotal() + button.getDenominationValue());
                            view.getMainContent().getCounterPage().getDenomination()
                                    .setLabelTotal(
                                            String.valueOf(order.getTotal()));
                        }
                    }
                }
            });
        });

        List<OtherActionButton> other_btns = view.getMainContent().getCounterPage().getDenomination()
                .getOtherActionButtons();
        other_btns.forEach(buttons -> {
            buttons.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println(buttons.getButton_name());
                }

            });
        });

        view.getMainContent().getCounterPage().getCategoryContainers().forEach(container -> {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    container.handle_click(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            if (container.getComponentName().equals("Documents and Office Prints")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "DocumentsandOfficeSub");
                            } else if (container.getComponentName().equals("Photo Prints")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "PhotoPrintsSub");

                            } else if (container.getComponentName().equals("Business Essentials")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "BusinessEssentialsSub");
                            } else if (container.getComponentName().equals("Promotional Materials")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "PromotionalMaterialsSub");
                            } else if (container.getComponentName().equals("Customized Items")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "CustomizedItemsSub");
                            } else if (container.getComponentName().equals("School/ Event Materials")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "SchoolEventMaterialsSub");
                            } else if (container.getComponentName().equals("Typing Job")) {
                                view.getMainContent().getCounterPage().getMenuContainerWrapperLayout().show(
                                        view.getMainContent().getCounterPage().getMenuContainerWrapper(),
                                        "TypingJobSub");
                            }

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            container.setBackground(Color.decode("#FAF0E6"));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            container.setBackground(Color.WHITE);
                        }

                    });
                }

            });
        });

        view.getMainContent().getCounterPage().getTable().handle_void_button(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getMainContent().getCounterPage().getTable().getSelectedRowIndex() < 0) {
                    JOptionPane.showMessageDialog(view, "select row first to remove or void from order.", null, 0);
                } else {
                    int optionChoosed = JOptionPane.showConfirmDialog(view,
                            String.format("Do you wish to void order [ %s ]",
                                    view.getMainContent().getCounterPage().getTable().getProductName()),
                            "Void", 0);

                    switch (optionChoosed) {
                        case 0:
                            view.getMainContent().getCounterPage().getOrderContextModel().subtractTotalOrderPrice(
                                    view.getMainContent().getCounterPage().getTable().getProductPrice());
                            view.getMainContent().getCounterPage().getTable().setTotalLabel(String.valueOf(
                                    view.getMainContent().getCounterPage().getOrderContextModel()
                                            .getTotalOrderPrice()));
                            System.out.println("Total Order Price: "
                                    + view.getMainContent().getCounterPage().getOrderContextModel()
                                            .getTotalOrderPrice());
                            view.getMainContent().getCounterPage().getTable()
                                    .removeFromTable(
                                            view.getMainContent().getCounterPage().getTable().getSelectedRowIndex());
                            break;

                        default:
                            break;
                    }
                }

            }

        });

    }

    public HomeMenu getView() {
        return this.view;
    }

    public OrderData getOrderData() {
        return this.order;
    }
}
