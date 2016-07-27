package internetapp.common;

import java.util.ArrayList;

/**
 * Created by Sevumyan on 27.07.2016.
 */
public class ProductService {

    int productsQ = 5;
    private String[] brands = {"Apple", "HTC", "Samsung", "Sony", "Xiaomi"};
    private String[] descriptions = {"","","","",""};
    private Double[] prices = {40000.00,35000.00,36000.00,38000.00,15000.00};
    private int[] quantities = {100, 20, 50, 30, 25};
    public ArrayList<Product> init(){
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i =0;i< productsQ; i++){
            products.add(new Product(brands[i], prices[i], descriptions[i], quantities[i]));
        }
        return products;
    }

}
