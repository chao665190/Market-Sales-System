
package digitalmarketing.CustomerManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;


public class CustomerDirectory {

    Business business;
    ArrayList<CustomerProfile> customerlist;

    public CustomerDirectory(Business b) {

        business = b;
        customerlist = new ArrayList();

    }

    public CustomerProfile newCustomerProfile(String ct, String n, float ds) {
        
        CustomerProfile sp = new CustomerProfile(ct, n, ds);
        customerlist.add(sp);
        return sp;
    }     
}
