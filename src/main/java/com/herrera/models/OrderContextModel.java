package com.herrera.models;

public class OrderContextModel {
    double totalOrderPrice, totalPayment, totalChange;

    public double getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(double totalChange) {
        this.totalChange = totalChange;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice += totalOrderPrice;
    }

    public void resetTotalOrderPrice() {
        this.totalOrderPrice = 0;
    }

    public void resetTotalPayment() {
        this.totalPayment = 0;
    }

    public void resetTotalChange() {
        this.totalChange = 0;
    }

    public void subtractTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice -= totalOrderPrice;

    }
}
