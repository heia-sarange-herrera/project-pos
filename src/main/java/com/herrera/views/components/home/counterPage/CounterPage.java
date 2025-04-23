package com.herrera.views.components.home.counterPage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.herrera.models.Order;
import com.herrera.views.components.Components;
import com.herrera.views.components.home.counterPage.subcategory.CategorySubs;
import com.herrera.views.components.reusable.ProductCategoryContainer;
import com.herrera.views.components.reusable.ProductContainer;
import com.herrera.views.components.themes.Themes;

public class CounterPage extends Components {

    Order order = new Order();

    JPanel groupButtonContainer, counterContainer, menuContainer, orderContainer, menuContainerCardCategory,
            menuContainerWrapper, DocumentsandOfficeSub, PhotoPrintsSub, BusinessEssentialsSub, PromotionalMaterialsSub,
            CustomizedItemsSub, TypingJobSub;

    JButton btnMenu, btnOrder;
    Denomination denomination;
    JScrollPane menuContainerScroller;

    CardLayout menuContainerCardCategoryLayout, menuContainerWrapperLayout;
    List<ProductCategoryContainer> pls;
    private OrderTable table;

    public CounterPage(String component_name) {
        super(component_name);

        // setup containers
        table = new OrderTable("Table");
        groupButtonContainer = new JPanel();
        counterContainer = new JPanel();
        menuContainer = new JPanel();
        orderContainer = new JPanel();
        btnMenu = new JButton("Menu");
        btnMenu.setPreferredSize(Themes.Btn_Regular_Dimension);

        btnOrder = new JButton("Orders");
        btnOrder.setPreferredSize(Themes.Btn_Regular_Dimension);

        // setup
        setLayout(new BorderLayout());
        setPreferredSize(Themes.Container_Large_Dimension);

        // group button container
        groupButtonContainer.setLayout(new GridBagLayout());
        groupButtonContainer.setPreferredSize(new Dimension(this.getWidth(), 55));
        groupButtonContainer.add(btnMenu);
        groupButtonContainer.add(btnOrder);

        // counter container
        counterContainer.setLayout(new CardLayout());

        // add to counter container

        //
        DocumentsandOfficeSub = new JPanel();
        DocumentsandOfficeSub.setLayout(new BorderLayout());
        DocumentsandOfficeSub.add(new CategorySubs("DocumentsandOfficeSub", Arrays.asList(
                new ProductContainer("product-component", "Photo Copy", .75),
                new ProductContainer("product-component", "Print Colored", 3),
                new ProductContainer("product-component", "Print Black", 1),
                new ProductContainer("product-component", "Document Scan", 5)), this.table), BorderLayout.CENTER);
        DocumentsandOfficeSub.add(createBackButton(), BorderLayout.SOUTH);
        //
        PhotoPrintsSub = new JPanel();
        PhotoPrintsSub.setLayout(new BorderLayout());
        PhotoPrintsSub.add(new CategorySubs("PhotoPrintsSub",
                Arrays.asList(new ProductContainer("product-component", "Package 1", 35),
                        new ProductContainer("product-component", "Package 2", 35),
                        new ProductContainer("product-component", "Package 3", 45),
                        new ProductContainer("product-component", "Package 4", 55),
                        new ProductContainer("product-component", "Package 5", 75),
                        new ProductContainer("product-component", "A4 Size", 99)), this.table),
                BorderLayout.CENTER);
        PhotoPrintsSub.add(this.createBackButton(), BorderLayout.SOUTH);
        //
        BusinessEssentialsSub = new JPanel();
        BusinessEssentialsSub.setLayout(new BorderLayout());
        BusinessEssentialsSub.add(new CategorySubs("BusinessEssentialsSub",
                Arrays.asList(new ProductContainer("product-component", "Business Cards (per 1pg)", 10),
                        new ProductContainer("product-component", "Flyers (per 10pc)", 10),
                        new ProductContainer("product-component", "Customized Invoiced (per pad)", 25),
                        new ProductContainer("product-component", "Letterheads (per 1pg)", .75),
                        new ProductContainer("product-component", "Company ID's (per 1pc)", 20)), this.table),
                BorderLayout.CENTER);
        BusinessEssentialsSub.add(this.createBackButton(), BorderLayout.SOUTH);
        //
        PromotionalMaterialsSub = new JPanel();
        PromotionalMaterialsSub.setLayout(new BorderLayout());
        PromotionalMaterialsSub.add(new CategorySubs("PromotionalMaterialsSub", Arrays.asList(
                new ProductContainer("product-component", "Tarps 1-50cm", 100),
                new ProductContainer("product-component", "Tarps 51-79cm", 200),
                new ProductContainer("product-component", "Tarps 80-100cm", 500),
                new ProductContainer("product-component", "B-Day Tarps", 250)), this.table), BorderLayout.CENTER);
        PromotionalMaterialsSub.add(this.createBackButton(), BorderLayout.SOUTH);
        //
        CustomizedItemsSub = new JPanel();
        CustomizedItemsSub.setLayout(new BorderLayout());
        CustomizedItemsSub.add(new CategorySubs("CustomizedItemsSub", Arrays.asList(
                new ProductContainer("product-component", "Mug (per 1pc)", 50),
                new ProductContainer("product-component", "Shirts (per 1pc)", 99),
                new ProductContainer("product-component", "Tote Bag (per 1pc)", 99),
                new ProductContainer("product-component", "Keychain (per 1pc)", 45)), this.table), BorderLayout.CENTER);
        CustomizedItemsSub.add(this.createBackButton(), BorderLayout.SOUTH);
        //
        //
        TypingJobSub = new JPanel();
        TypingJobSub.setLayout(new BorderLayout());
        TypingJobSub.add(new CategorySubs("TypingJobSub", Arrays.asList(
                new ProductContainer("product-component", "Resume", 30),
                new ProductContainer("product-component", "Resignation Letter", 30),
                new ProductContainer("product-component", "Other Types (per page)", 35)), this.table), BorderLayout.CENTER);
        TypingJobSub.add(this.createBackButton(), BorderLayout.SOUTH);
        //
        menuContainerWrapperLayout = new CardLayout();
        menuContainerWrapper = new JPanel(menuContainerWrapperLayout);
        menuContainerWrapper.add(menuContainer, "menuContainer");
        menuContainerWrapper.add(DocumentsandOfficeSub, "DocumentsandOfficeSub");
        menuContainerWrapper.add(PhotoPrintsSub, "PhotoPrintsSub");
        menuContainerWrapper.add(BusinessEssentialsSub, "BusinessEssentialsSub");
        menuContainerWrapper.add(PromotionalMaterialsSub, "PromotionalMaterialsSub");
        menuContainerWrapper.add(CustomizedItemsSub, "CustomizedItemsSub");
        menuContainerWrapper.add(TypingJobSub, "TypingJobSub");

        menuContainer.setLayout(new GridLayout(3, 3, 5, 5));
        menuContainerScroller = new JScrollPane(menuContainerWrapper);
        menuContainerScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pls = Arrays.asList(
                new ProductCategoryContainer("Documents and Office Prints", "Documents and Office Prints"),
                new ProductCategoryContainer("Photo Prints", "Photo Prints"),
                new ProductCategoryContainer("Business Essentials", "Business Essentials"),
                new ProductCategoryContainer("Promotional Materials", "Promotional Materials"),
                new ProductCategoryContainer("Customized Items", "Customized Items"),
                new ProductCategoryContainer("Typing Job", "Typing Job"));
        pls.forEach(container -> {
            menuContainer.add(container);
        });
        menuContainerCardCategoryLayout = new CardLayout();

        // end menu container

        // order container
        orderContainer.setLayout(new BorderLayout());
        denomination = new Denomination("denomination");
        orderContainer.add(denomination, BorderLayout.WEST);
        orderContainer.add(table, BorderLayout.EAST);
        // end order container

        // add components to counter container
        counterContainer.add(menuContainerScroller, "menuContainer");
        counterContainer.add(orderContainer, "orderContainer");

        // add to main container
        add(groupButtonContainer, BorderLayout.NORTH);
        add(counterContainer, BorderLayout.CENTER);
    }

    public void handleBtnMenu(ActionListener e) {
        this.btnMenu.addActionListener(e);
    }

    public void handleBtnOrder(ActionListener e) {
        this.btnOrder.addActionListener(e);
    }

    public CardLayout getLayoutUsed() {
        return (CardLayout) counterContainer.getLayout();
    }

    public JPanel getCounterContainer() {
        return this.counterContainer;
    }

    public Denomination getDenomination() {
        return this.denomination;
    }

    public CardLayout getMenuContainerCardCategory() {
        return this.menuContainerCardCategoryLayout;
    }

    public CardLayout getMenuContainerWrapperLayout() {
        return this.menuContainerWrapperLayout;
    }

    public List<ProductCategoryContainer> getCategoryContainers() {
        return this.pls;
    }

    public JPanel getMenuContainerWrapper() {
        return menuContainerWrapper;
    }

    public JScrollPane getMenuContainerScroller() {
        return menuContainerScroller;
    }

    public JButton createBackButton() {
        JButton back_button = new JButton("Back");
        back_button.setPreferredSize(Themes.Btn_Regular_Dimension);
        back_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                menuContainerWrapperLayout.show(menuContainerWrapper, "menuContainer");

            }

        });

        return back_button;
    }

    public Order getOrder() {
        return order;
    }
}
