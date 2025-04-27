package com.herrera.views.components.home.counterPage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.herrera.views.components.Components;
import com.herrera.views.components.themes.Themes;

public class OrderTable extends Components {

    JTable orderTable;
    JScrollPane orderTableScrollPane;
    DefaultTableModel orderTableModel;
    String[] columnName = { "Product", "Price" };
    JPanel crudContainer;
    JButton voidBtn;


    public OrderTable(String component_name) {
        super(component_name);

        // this
        setLayout(new BorderLayout());
        // instantiate properties

        crudContainer = new JPanel(new FlowLayout(FlowLayout.LEADING));
        voidBtn = new JButton("Void");
        voidBtn.setPreferredSize(new Dimension(100, 33));
        crudContainer.setPreferredSize(new Dimension(450, 55));
        crudContainer.add(voidBtn);
        orderTableModel = new DefaultTableModel(columnName, 0);
        orderTable = new JTable(orderTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for all cells
            }
        };
        orderTable.addMouseListener(null);
        orderTableScrollPane = new JScrollPane(orderTable);
        orderTableScrollPane.setPreferredSize(new Dimension(300, 300));
        add(orderTableScrollPane, BorderLayout.NORTH);
        add(crudContainer, BorderLayout.CENTER);
    }

    public void addRowToTable(Object[] row) {
        orderTableModel.addRow(row);
    }

    public void handle_void_button(ActionListener e) {
        this.voidBtn.addActionListener(e);
    }

    public void handle_Table_event(ListSelectionListener e) {
        this.orderTable.getSelectionModel().addListSelectionListener(e);
    }

    

    public int getSelectedRowIndex() {
        return this.orderTable.getSelectedRow();
    }

    public int getSelectedCol() {
        return this.orderTable.getSelectedColumn();
    }

    public void removeFromTable(int index){
        this.orderTableModel.removeRow(index);
    }

    public Object getProductName(){
        return this.orderTable.getValueAt(this.getSelectedRowIndex(), 0);
    }


}
