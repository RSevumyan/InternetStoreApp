package internetapp.common;

import org.springframework.stereotype.Service;

/**
 * Created by Sevumyan on 27.07.2016.
 *
 * Класс, содержащий в себе информацию о реализуемом товаре.
 */

@Service("product")
public class Product {
    /**
     * Наименование товара
     */
    private String name;
    /**
     * Цена товара
     */
    private double price;
    /**
     * Описание товара
     */
    private String description;
    /**
     * количество товара
     */
    private int quantity;

    /**
     * Метод выставления наименования товара.
     * @param name - Наименование товара;
     */
    public void setName(String name){
        this.name=name;
    }
    /**
     * Метож, возвращающий наименование товара.
     * @return Имя товара
     */
    public String getName(){
        return name;
    }

    /**
     * Метод выставления описания товара.
     * @param description - описание товара.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Метод, возвращающий описание товара.
     *
     * @return Описание товара.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Метод выставления цены товара.
     * @param price - цена товара.
     */

    public void setPrice(double price){
        this.price=price;
    }

    /**
     * Метод, возвращающий цену товара.
     *
     * @return Цена товара.
     */
    public double getPrice(){
        return price;
    }

    /**
     * Метод выставления количества товара.
     * @param quantity - количество товара.
     */
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    /**
     * Метод, возвращающий количество товара.
     * @return количество товара.
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * Метод, изменяющий параметр количества товара
     *
     * @param newQ - новое количество товара.
     */
    public void changeQuantity(int newQ){
        this.quantity=newQ;
    }

    /**
     * Метод, позволяющий определяющий доступность товара.
     * @return true - если товар есть в наличии, false - если товара нет в наличии.
     */
    public boolean availability(){
        if(quantity<1)return false;
        else return true;
    }
}