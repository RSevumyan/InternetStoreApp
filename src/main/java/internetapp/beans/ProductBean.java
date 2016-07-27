package internetapp.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import internetapp.common.Product;
import internetapp.common.ProductService;

import java.util.ArrayList;
/**
 * Created by Sevumyan on 27.07.2016.
 */

@ManagedBean(name="productBean")
@RequestScoped
public class ProductBean {

    private ArrayList<Product> products;

    public Product selectedProduct;

    private ProductService service = new ProductService();

    public void init(){
        products=service.init();

    }




}

