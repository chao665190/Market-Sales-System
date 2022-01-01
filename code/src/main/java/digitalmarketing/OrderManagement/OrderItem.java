
package digitalmarketing.OrderManagement;

import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.SolutionOffer;


public class OrderItem {
    
    SolutionOffer item;
    float actualPrice;
    int quantity;

    public OrderItem(SolutionOffer item, int quantity, float customerdiscount, float channeldiscount) {
        this.item = item;
        item.addToSold(this); //make sure product links back to the item
        this.quantity = quantity;
        actualPrice =  (1f - customerdiscount) * (1f - channeldiscount) * item.getPrice();
    }

    public float getOrderItemTotal() {
        return actualPrice * quantity; 
    }

    public float getOrderItemProfit() {
        return (actualPrice - item.getCost()) * quantity;
    }
}
