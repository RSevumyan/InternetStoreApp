package internetapp.dbconnection.interfaces;

import internetapp.logic.Product;
import java.util.List;

/**
 * Created by Sevumyan on 03.08.2016.
 */
public interface ProductDAO {

    public List<Product> getList();

    public void addProduct(Product product);

    public void deleteProduct(Integer id);

}
