package internetapp.logic.impl;

import internetapp.dbconnection.impl.ProductDAOImpl;
import internetapp.logic.Product;
import internetapp.logic.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedProperty;
import java.util.List;

/**
 * Created by Sevumyan on 27.07.2016
 *
 * Класс работы со списком товаров(пока только инициализация)
 */
@Controller
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    private int productsQ = 5;
    private String[] brands = {"Apple Iphone 6S", "HTC 10", "Samsung Galaxy S7", "Sony Xperia X", "Xiaomi RedMi 3"};
    private String[] descriptions = {"Бесполезный кирпич","Строгий и элегантный телефон","Инновации на максимуме","Стиль и надежность","Китайское откровение"};
    private Double[] prices = {40000.00,35000.00,36000.00,38000.00,15000.00};
    private int[] quantities = {100, 20, 50, 30, 25};

    @ManagedProperty(value = "#{productDAOImpl}")
    private ProductDAOImpl productDAOImpl;

    public void setProductDAOImpl(ProductDAOImpl productDAOImpl){this.productDAOImpl = productDAOImpl;}

    /**
     * Метод инициалиции списка товаров.
     * @return Список товаров.
     */
    @Transactional
    public List<Product> init(){
        return  productDAOImpl.getList();
    }

}
