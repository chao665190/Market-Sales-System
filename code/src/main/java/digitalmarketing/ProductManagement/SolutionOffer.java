package digitalmarketing.ProductManagement;

import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.Market;
import java.util.ArrayList;
import digitalmarketing.OrderManagement.OrderItem;


public class SolutionOffer {
    
    String name;
    ArrayList<Product> products; 
    int price;
    ArrayList<String> availablemarkets;
    ArrayList<String> availablechannels;
    ArrayList<OrderItem> solutionsSold; // solutionSold can tell how many this kind of solution offer that be sold.
    
    
    public SolutionOffer(String n){
        name = n;
        products = new ArrayList<Product>(); 
        availablemarkets = new ArrayList<String>();
        availablechannels = new ArrayList<String>();
        solutionsSold = new ArrayList<OrderItem>();
    }
    
    public void addProduct(Product p){
        products.add(p);
    }
    
    public void addAvailableMarket(String s) {
        availablemarkets.add(s);
    }
    public void addAvailableChannel(String s) {
        availablechannels.add(s);
    }
    
    private boolean isAvailableMarket(String s) {
        for (String m : availablemarkets) {
            if (m == s) return true;
        }
        return false;
    }
    
    private boolean isAvailableChannel(String s) {
        for (String c : availablechannels) {
            if (c == s) return true;
        }
        return false;
    }
    
    public boolean isAvailable(String market, String channel) {
        return isAvailableMarket(market) && isAvailableChannel(channel);
    }
    
    public void setPrice(int p){
        price = p;        
    }

    public int getPrice() {
        return price;
    }

    
    public void addToSold(OrderItem item){
        solutionsSold.add(item);   
    }

    public String getName() {
        return name;
    }

    public void printRevenue() {
        float total = 0;
        for (OrderItem oi : solutionsSold) {
            total += oi.getOrderItemTotal();
        }
        System.out.println("The revenues of the " + name + " are "+ total + " dollar.");
    }

    public float getCost() {
        float sum = 0;
        for (Product p : products) {
            sum += p.getPurchaseprice();
        }
        return sum;
    }
    
    public void printProductList() {
        System.out.println("Solution offer name: " + name);
        System.out.println("Product list:");
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
    
}
