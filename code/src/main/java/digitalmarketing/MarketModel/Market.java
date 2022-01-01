package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;
import digitalmarketing.OrderManagement.OrderItem;
import java.util.ArrayList;

public class Market {

    Business business;
    String name;
    ArrayList<OrderItem> solutionsSold;

    public Market(Business b, String s) {
        business = b;
        name = s;
        solutionsSold = new ArrayList();
    }

    public String getName() {
        return name;
    }
    
    // products that sold by this market are added to the SolutionSold arraylist.
    public void addToSold(OrderItem item){
        solutionsSold.add(item);    
    }
    
    public void printRevenue() {
        float total = 0;
        for (OrderItem oi : solutionsSold) {
            total += oi.getOrderItemTotal();
        }
        System.out.println("The revenues of " + name + " are "+ total + " dollar.");
    }
}
