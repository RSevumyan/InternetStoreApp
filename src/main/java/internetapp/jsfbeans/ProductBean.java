package internetapp.jsfbeans;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import internetapp.common.Product;
import internetapp.common.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sevumyan on 27.07.2016.
 *
 * Класс Bean для взаимодействия с товарами.
 */
@Controller
@ManagedBean(name="productBean")
@SessionScoped
public class ProductBean {

    /**
     * Список товаров.
     */
    @Autowired
    private List<Product> products;
    /**
     * Конкретный товар.
     */
    @Autowired
    private Product selectedProduct;

   @ManagedProperty(value = "#{productServiceImpl}")
    private ProductServiceImpl service;

    @PostConstruct
    public void init(){
        this.products=service.init();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getSelectedProduct(){
        return selectedProduct;

    }

    public void setSelectedProduct(Product selectedProduct){
        this.selectedProduct = selectedProduct;
    }

    public void setService(ProductServiceImpl service) {
        this.service = service;
    }

}

