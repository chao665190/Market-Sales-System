
package digitalmarketing.MarketModel;

import digitalmarketing.Business.Business;
import digitalmarketing.OrderManagement.OrderItem;
import java.util.ArrayList;


public class Channel {
    
    Business business;
    String name;
    float discount;
    ArrayList<OrderItem> solutionsSold;
    
    
    
    public Channel(Business b, String n, float d){
        business = b;
        name = n;
        discount = d;
        solutionsSold = new ArrayList();
        
    }

    public String getName() {
        return name;
    }

    public float getDiscount() {
        return discount;
    }
    
    public void addToSold(OrderItem item){
        solutionsSold.add(item);    
    }
    
    public void printRevenue() {
        float total = 0;
        for (OrderItem oi : solutionsSold) {
            total += oi.getOrderItemTotal();
        }
        System.out.println("The revenues of the channel " + name + " are "+ total + " dollar.");
    }   
    
}
