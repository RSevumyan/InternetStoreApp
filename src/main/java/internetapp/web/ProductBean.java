package internetapp.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import internetapp.dbconnection.impl.ProductDAOImpl;
import internetapp.dbconnection.interfaces.ProductDAO;
import internetapp.logic.Product;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private Date date;

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

   /*@ManagedProperty(value = "#{productServiceImpl}")
    private ProductServiceImpl service;

    @PostConstruct
    public void init(){
        this.products=service.init();
    }

    public void setService(ProductServiceImpl service) {
        this.service = service;
    }*/

    @ManagedProperty(value = "#{productDao}")
    private ProductDAO productDao;

    @PostConstruct
    public void init() {
        this.products = productDao.getList();
    }

    public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
