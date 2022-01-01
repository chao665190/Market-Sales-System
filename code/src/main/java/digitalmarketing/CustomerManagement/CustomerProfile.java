
package digitalmarketing.CustomerManagement;

import digitalmarketing.OrderManagement.Order;
import java.util.ArrayList;


public class CustomerProfile {
    
    String customertype;
    String name;
    float discount;
    ArrayList<Order> orders;
    

    public CustomerProfile(String ct, String n, float ds) {
        customertype = ct;
        name = n;
        discount = ds;
        orders = new ArrayList();

    }
    
    public String getName(){
        return name;
    }

    public float getDiscount() {
        return discount;
    }

    public String getCustomertype() {
        return customertype;
    }
    
    public void addCustomerOrder(Order o){
        orders.add(o);
    }    
}
