
package digitalmarketing.ProductManagement;

import digitalmarketing.Business.Business;
import java.util.ArrayList;


public class ProductCatalog {

    Business business;
    ArrayList<Product> products;

    public ProductCatalog(Business b) {
        business = b;
        products = new ArrayList();
    }

    public Product newProduct(int pp, String n) {
        Product p = new Product(pp,n);
        products.add(p);
        return p;
    }       
}
