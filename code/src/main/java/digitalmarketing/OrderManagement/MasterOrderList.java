
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.Advertising.Advertising;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.Market;


public class MasterOrderList {
    Business business;
    ArrayList<Order> orders;

    public MasterOrderList(Business b) {
        business = b;
        orders = new ArrayList();
    }

    public Order newOrder(CustomerProfile cp, Market m, Channel c, Advertising a) {
        Order o = new Order(cp, m, c, a);
        orders.add(o);
        return o; // then, use in main class
    }
    
    public void printProfit() {
        float total = 0;
        for (Order o : orders) {
            total += o.getOrderProfit();
        } 
        System.out.println("The profit of all orders are "+ total + " dollar.");
    }

}
