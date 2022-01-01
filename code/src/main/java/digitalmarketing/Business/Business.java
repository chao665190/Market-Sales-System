package digitalmarketing.Business;

import digitalmarketing.Advertising.Advertising;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.OrderManagement.MasterOrderList;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.ProductManagement.SolutionOffer;
import java.util.ArrayList;

public class Business {

    String name;
    MasterOrderList masterorderlist;
    CustomerDirectory customers;
    ProductCatalog productcatalog;
    ArrayList<Market> markets;
    ArrayList<Channel> channels;
    ArrayList<SolutionOffer> solutionoffers;
    ArrayList<Advertising> ads;

    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList(this);
        customers = new CustomerDirectory(this);
        productcatalog = new ProductCatalog(this);
        markets = new ArrayList();
        channels = new ArrayList();
        solutionoffers = new ArrayList();
        ads = new ArrayList();
    }

    public void printTitle() {
        System.out.println("Business : " + name);
    }

    public Market newMarket(String s) {
        Market m = new Market(this, s);
        markets.add(m);
        return m;
    }

    public Channel newChannel(String n, float d) {
        Channel c = new Channel(this, n, d);
        channels.add(c);
        return c;
    }

    public void addNewSolutionOffer(SolutionOffer s) {
        solutionoffers.add(s);
    }
    
    public Advertising newAdvertising(String c, String ct, int co) {
        Advertising ad = new Advertising(this, c, ct, co);
        ads.add(ad);
        return ad;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customers;
    }

    public MasterOrderList getMasterorderlist() {
        return masterorderlist;
    }

    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }

    public void browse(CustomerProfile c, Market market, Channel channel) {
        for (Advertising ad : ads) {
            if (ad.getCustomerType() == c.getCustomertype()) { //check whether equal 
                // customer type decides ads' content
                System.out.println(ad.getContent());
                break;
            }
        }
        for (SolutionOffer s : solutionoffers) {
            if (s.isAvailable(market.getName(), channel.getName())) {
                
                s.printProductList();
                System.out.println("Offer price: " + (1 - c.getDiscount()) * (1 - channel.getDiscount()) * s.getPrice());
            }
        }
        System.out.println("--------------------------------------------");
    }

}
