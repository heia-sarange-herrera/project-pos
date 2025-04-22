package com.herrera.views.components.home.counterPage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.herrera.views.components.Components;

public class OrderTable extends Components {

    JTable orderTable;
    JScrollPane orderTableScrollPane;
    DefaultTableModel orderTableModel;

    public OrderTable(String component_name) {
        super(component_name);

        // this

        // instantiate properties
        orderTable = new JTable();

        orderTableScrollPane = new JScrollPane(orderTable);

    }

}
