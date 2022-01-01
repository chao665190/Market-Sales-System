
package digitalmarketing.ProductManagement;

import java.util.ArrayList;
import digitalmarketing.OrderManagement.OrderItem;


public class Product {

    private String name;
    private int purchaseprice;
    ArrayList<OrderItem> orderitems;

    public Product(int pp, String n) {
        purchaseprice = pp;
        orderitems = new ArrayList();
        name = n;
    }

    
    public void addOrderItem(OrderItem oi) {
        orderitems.add(oi);
    }

    public String getName() {
        return name;
    }

    public int getPurchaseprice() {
        return purchaseprice;
    }

}
