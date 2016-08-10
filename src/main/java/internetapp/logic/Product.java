package internetapp.logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * Created by Sevumyan on 27.07.2016.
 *
 * Класс, содержащий в себе информацию о реализуемом товаре.
 */

@Entity
@Table(name ="products")
public class Product {

    /**
     * ID товара
     */
    @Id
    @Column(name="id")
    //@GeneratedValue
    private Integer id;

    /**
     * Наименование товара
     */
    @Column(name="name")
    private String name;

    /**
     * Цена товара
     */
    @Column(name="price")
    private double price;

    /**
     * Описание товара
     */
    @Column(name="description")
    private String description;

    /**
     * количество товара
     */
    @Column(name="quantity")
    private short quantity;

    /**
     * Setter ID
     * @param id - уникальный идентификатор товара
     */
    public void setId(Integer id){
        this.id=id;
    }

    /**
     * Getter ID
     * @return ID товара
     */
    public Integer getId(){
        return this.id;
    }

    /*
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
    public void setQuantity(short quantity){
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
    public void changeQuantity(short newQ){
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

    /**
     * Переопределенный метод toString
     * @return Строка, содержащая всю информацию по сущности.
     */
    @Override
    public String toString(){
        return  this.id+"\t"+
                this.name +"\t"+
                this.price+"\t"+
                this.description+"\t"+
                this.quantity+"\t";
    }
}