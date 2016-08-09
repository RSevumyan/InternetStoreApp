package internetapp.dbconnection.impl;

import internetapp.dbconnection.interfaces.ProductDAO;
import internetapp.logic.Product;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sevumyan on 02.08.2016.
 */
@Repository("productDao")
public class ProductDAOImpl implements ProductDAO {

    public ProductDAOImpl(){

    }

    public ProductDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionfactory(SessionFactory sessionfactory){
        this.sessionFactory = sessionfactory;
    }

    /*public void setSessionfactory(){

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            this.sessionfactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
    }*/

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }


    @Transactional
    public void addProduct(Product product){
        sessionFactory.getCurrentSession().save(product);
    }

    public Product getProduct(Integer id){
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Product> getList(){
        List<Product> list = (List<Product>) sessionFactory.getCurrentSession().createQuery("from internetapp.logic.Product").list();
        return list;
    }

    @Transactional
    public void deleteProduct(Integer id){
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        if(product != null){
            sessionFactory.getCurrentSession().delete(product);
        }
    }
}