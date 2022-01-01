package digitalmarketing.OrderManagement;

import digitalmarketing.Advertising.Advertising;
import java.util.ArrayList;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.ProductManagement.SolutionOffer;

public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    Market market;
    Channel channel;
    Advertising ad;


    public Order(CustomerProfile cp, Market m, Channel c, Advertising a) {
        orderitems = new ArrayList();
        customer = cp;
        market = m;
        channel = c;
        ad = a;
        customer.addCustomerOrder(this); //we link the order to the customer
    }

    public OrderItem newOrderItem(SolutionOffer s, int q) {
        OrderItem oi = new OrderItem(s, q, customer.getDiscount(), channel.getDiscount());
        orderitems.add(oi);
        market.addToSold(oi);
        channel.addToSold(oi);
        ad.addToSold(oi);
        return oi;
    }

    public float getOrderProfit() {
        float sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemProfit();    
        }
        sum -= ad.getCost();
        return sum;
    }

}
