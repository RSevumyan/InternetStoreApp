package internetapp.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import internetapp.dbconnection.interfaces.OverallDAO;
import internetapp.logic.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Sevumyan on 27.07.2016.
 * <p>
 * Класс Bean для взаимодействия с товарами.
 */
@Controller
@ManagedBean(name = "productBean")
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

    /**
     *Сервис доступа к базе данных.
     */
    @ManagedProperty(value = "#{overallDao}")
    private OverallDAO<Product> overallDao;

    /**
     * Метод инициализации списка товаров.
     */
    @PostConstruct
    public void init() {
        this.products = overallDao.getList();
    }

    /**
     *
     * @param overallDao
     */
    public void setOverallDao(OverallDAO<Product> overallDao) {
        this.overallDao = overallDao;
    }

    /**
     *
     * @return
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     *
     * @return
     */
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    /**
     *
     * @param selectedProduct
     */
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

}

