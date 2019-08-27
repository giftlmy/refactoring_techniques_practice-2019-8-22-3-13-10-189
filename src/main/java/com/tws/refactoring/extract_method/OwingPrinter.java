package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;
        // print owings
        outstanding = getOutstanding(elements, outstanding);

        // print banner、details
        printDetails(name, outstanding);
    }

    private double getOutstanding(Iterator<Order> elements, double outstanding) {
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    private void printDetails(String name, double outstanding) {
        System.out.println (
                "*****************************\n"+
                "****** Customer totals ******\n"+
                "*****************************\n"+
                        "name: " + name+"\n"+
                        "amount: " + outstanding);//合并
    }
}

class Order {
    private  double amount;//去掉了final

    public Order(double amount) {

        this.amount = amount;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {//添加了set方法
        this.amount = amount;
    }
}
