package com.herrera.views.tests;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.herrera.views.components.Components;

public class OrderTable extends Components {

    JTable table;
    JScrollPane scrollPane;

    public OrderTable(String component_name) {
        super(component_name);
        // this
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        // setup table
        String[] columnNames = { "Product", "Qty","Amount" };
        Object[][] data = {

                { "Product 1", 2, 20.0 },
                { "Product 2", 1, 10.0 },
                { "Product 3", 5, 50.0 },
                { "Product 4", 3, 30.0 },
                { "Product 5", 4, 40.0 },
                { "Product 6", 6, 60.0 },
                { "Product 7", 7, 70.0 },
                { "Product 8", 8, 80.0 },
                { "Product 9", 9, 90.0 },
                { "Product 10", 10, 100.0 }

        };
        table = new JTable(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for all cells
            }
        };
        ;
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JButton btn = new JButton("Get Selected Row Value");
        btn.setPreferredSize(new Dimension(200, 30));
        btn.addActionListener(e -> {
            String selectedValue = getTests();
            System.out.println("Selected Value: " + selectedValue);
        });
        
        scrollPane = new JScrollPane(table);
        add(scrollPane);

        

    }
    public String getTests() {


        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Object value = table.getValueAt(selectedRow, 0); // Get the value of the first column in the selected row
            return value.toString(); // Return the value as a string
        } else {
            return "No row selected"; // Handle case when no row is selected
        }

    }
}
