package internetapp.dbconnection.interfaces;

import internetapp.logic.Product;
import java.util.List;

/**
 * Created by Sevumyan on 03.08.2016.
 * Интерфейс доступа к данным
 */
public interface OverallDAO<T> {
    /**
     * Получение списка сущностей
     * @return
     */
    public List<T> getList();

    public void addEntity(T t);

    public void deleteEntity(Integer id);

}
