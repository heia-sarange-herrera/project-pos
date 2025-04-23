package com.herrera.models;

import java.util.List;

public class OrderData {
    
    private int total;
    private List<String> orderList;
    
    public List<String> getOrderList() {
        return orderList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
