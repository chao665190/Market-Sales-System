package digitalmarketing.Advertising;

import digitalmarketing.Business.Business;
import digitalmarketing.OrderManagement.OrderItem;
import java.util.ArrayList;

public class Advertising {
    
    Business business;
    String content;
    String customertype;
    int cost;
    ArrayList<OrderItem> solutionsSold;

    public Advertising(Business b, String c, String ct, int co){
        business = b;
        content = c;  
        customertype = ct;
        cost = co;
        solutionsSold = new ArrayList();
    }

    public String getContent() {
        return content;
    }
    
    public void addToSold(OrderItem item){
        solutionsSold.add(item);    
    }

    public int getCost() {
        return cost;
    }
    
    public String getCustomerType() {
        return customertype;
    }
    public void printRevenue() {
        float total = 0;
        for (OrderItem oi : solutionsSold) {
            total += oi.getOrderItemTotal();
        }
        System.out.println("The revenues of the advertisement ---------- " + content + " ---------- are "+ total + " dollar.");
    }
    
    
}



    