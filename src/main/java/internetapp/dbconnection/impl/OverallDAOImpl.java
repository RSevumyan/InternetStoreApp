package internetapp.dbconnection.impl;

import internetapp.dbconnection.interfaces.OverallDAO;
import internetapp.logic.Product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sevumyan on 02.08.2016.
 */
@Repository("overallDao")
public class OverallDAOImpl<T> implements OverallDAO<T> {

    public OverallDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionfactory(SessionFactory sessionfactory){
        this.sessionFactory = sessionfactory;
    }


    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }


    @Transactional
    public void addEntity(T tob){
        sessionFactory.getCurrentSession().save(tob);
    }

    public T getProduct(Integer id){
        return (T) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> getList(){
        List<T> list = (List<T>) sessionFactory.getCurrentSession().createQuery("from internetapp.logic.Product").list();
        return list;
    }

    @Transactional
    public void deleteEntity(Integer id){
        T ob = (T) sessionFactory.getCurrentSession().load(Product.class, id);
        if(ob != null){
            sessionFactory.getCurrentSession().delete(ob);
        }
    }
}