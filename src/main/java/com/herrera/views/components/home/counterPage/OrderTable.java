package com.herrera.views.components.home.counterPage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.herrera.views.components.Components;

public class OrderTable extends Components {

    JTable orderTable;
    JScrollPane orderTableScrollPane;
    DefaultTableModel orderTableModel;
    String[] columnName = { "Product", "Price" };

    public OrderTable(String component_name) {
        super(component_name);

        // this

        // instantiate properties

        orderTableModel = new DefaultTableModel(columnName, 0);
        orderTable = new JTable(orderTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for all cells
            }
        };

        orderTableScrollPane = new JScrollPane(orderTable);
        add(orderTableScrollPane);
    }

    public void addRowToTable(Object[] row){
        orderTableModel.addRow(row);
    }

}
