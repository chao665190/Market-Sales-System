package digitalmarketing;

import digitalmarketing.Advertising.Advertising;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.OrderManagement.MasterOrderList;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.OrderManagement.OrderItem;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.ProductManagement.SolutionOffer;



public class DigitalMarketing {
    
    public static void main(String[] args) {
        
        Business costco = new Business("Costco Wholesale Corporation"); // creat  business object
        
        //Product
        //The first way to creat new objects, and put them into Business.
        
        ProductCatalog productCatalog = costco.getProductCatalog(); // get the product Catalog in costco 
        
        Product chocolate1 = productCatalog.newProduct(15,"chocolate1"); // creat new product in product Catalog
        Product chocolate2 = productCatalog.newProduct(10,"chocolate2");
        Product chocolate3 = productCatalog.newProduct(20,"chocolate3");
        
        Product nut1 = productCatalog.newProduct(18,"nut1");
        Product nut2 = productCatalog.newProduct(27,"nut2");
        Product nut3 = productCatalog.newProduct(30,"nut3");
        
        Product seafood1 = productCatalog.newProduct(70,"seafood1");
        Product seafood2 = productCatalog.newProduct(40,"seafood2");
        Product seafood3 = productCatalog.newProduct(50,"seafood3");
        
        //Customer
        
        CustomerDirectory customerDirectory = costco.getCustomerDirectory(); // get the customer directory in costco
        
        CustomerProfile  student1 =  customerDirectory.newCustomerProfile("student", "Chao",  0.1f); // creat new customer in customer directory
        CustomerProfile  student2 =  customerDirectory.newCustomerProfile("student", "Archil", 0.1f);
        CustomerProfile  generalcustomer =  customerDirectory.newCustomerProfile("general customer", "Joe", 0);
        
        //Channel
        //The Second way to creat new objects, and put them into Business.
        //because there are no channel directory, so I can not get it and creat channel in it.
        //But I have the channel arraylist. 
        //and function about channel, I will put them in the Business Class.
        //But function about customer will be put in the Customer Directory. And Busniess Class will be orgnized.
        Channel instore = costco.newChannel("in-store",  0);
        Channel online = costco.newChannel("Online PC web",  -0.1f);
        Channel mobileapp = costco.newChannel("Online Mobile app", 0.1f);
        
        
        //Advertising
        
        Advertising ad1 = costco.newAdvertising("Special discount applies!","student", 10);
        Advertising ad2 = costco.newAdvertising("Shopping, easy and fast!","general customer", 12);
        
        //Market
        Market market1 = costco.newMarket("US Market");
        Market market2 = costco.newMarket("China Market");
        
        // Solution Offer
        //The third way to creat new objects, and put them into Business.
        // 1.creat the object. 2.change the object 3.put the object in Business.
        SolutionOffer s1 = new SolutionOffer("Chocolate Box");
        SolutionOffer s2 = new SolutionOffer("Nut Box");
        SolutionOffer s3 = new SolutionOffer("Seafood Box");
        
        s1.addProduct(chocolate1); //add product in the solution offer // (before, I creat new product in product Catalog.)
        s1.addProduct(chocolate2);
        s1.addProduct(chocolate3);
        
        s2.addProduct(nut1);
        s2.addProduct(nut2);
        s2.addProduct(nut3);
        
        s3.addProduct(seafood1);
        s3.addProduct(seafood2);
        s3.addProduct(seafood3);
        
        s1.setPrice(70);
        s2.setPrice(100);
        s3.setPrice(250);
        
        
        s1.addAvailableMarket("US Market");
        s2.addAvailableMarket("US Market");
        s3.addAvailableMarket("China Market");
        
        s1.addAvailableChannel("in-store");
        s2.addAvailableChannel("Online PC web");
        s3.addAvailableChannel("Online Mobile app");
        
        costco.addNewSolutionOffer(s1);
        costco.addNewSolutionOffer(s2);
        costco.addNewSolutionOffer(s3);
        
        
        
        
        //browse
        costco.browse(student1, market1, instore);
        costco.browse(student2, market1, online);
        costco.browse(generalcustomer, market2, mobileapp);
        
        
        // All the orders
        MasterOrderList mol = costco.getMasterorderlist();

        //Products in one Shopping Cart(one order)
        Order order1 = mol.newOrder(student1, market1, instore, ad1);
        Order order2 = mol.newOrder(student2, market1, online, ad1);
        Order order3 = mol.newOrder(generalcustomer, market2, mobileapp, ad2);
        
        //Ordered Product
        OrderItem orderitem1 = order1.newOrderItem(s1, 2); // Chao 2 chocolate 
        OrderItem orderitem3 = order2.newOrderItem(s2, 3);// Archil 3 nut
        OrderItem orderitem4 = order3.newOrderItem(s3, 1);// Joe 1 seafood
        
        //calculate
        
        costco.printTitle();
        
        System.out.println("---------------------------------------------------------------");
        
        market1.printRevenue();
        market2.printRevenue();
        
        System.out.println("---------------------------------------------------------------");
        
        instore.printRevenue();
        online.printRevenue();
        mobileapp.printRevenue();
        
        System.out.println("------------------------------------------------------------------------------------------------------");
        
        ad1.printRevenue();
        ad2.printRevenue();
        
        System.out.println("---------------------------------------------------------------------------------------------------");
        
        s1.printRevenue();
        s2.printRevenue();
        s3.printRevenue();
        
        System.out.println("----------------------------------------------------------------");
        
        mol.printProfit();
           
    }
    
}
