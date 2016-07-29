package internetapp.common.impl;

import internetapp.common.Product;
import internetapp.common.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Sevumyan on 27.07.2016
 *
 * Класс работы со списком товаров(пока только инициализация)
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    private int productsQ = 5;
    private String[] brands = {"Apple", "HTC", "Samsung", "Sony", "Xiaomi"};
    private String[] descriptions = {"","","","",""};
    private Double[] prices = {40000.00,35000.00,36000.00,38000.00,15000.00};
    private int[] quantities = {100, 20, 50, 30, 25};

    /**
     * Метод инициалиции списка товаров.
     * @return Список товаров.
     */
    public ArrayList<Product> init(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product product;
        for (int i =0;i< productsQ; i++){
            products.add(new Product());
            product = products.get(i);
            product.setName(brands[i]);
            product.setDescription(descriptions[i]);
            product.setPrice(prices[i]);
            product.setQuantity(quantities[i]);
        }
        return products;
    }

}
