package internetapp.common;

/**
 * Created by Sevumyan on 27.07.2016.
 */
public class Product {

    private String name;

    private double price;

    private String description;

    private int quantity;

    Product(String name, double price, String description, int quantity){
        this.name=name;
        this.price=price;
        this.description=description;
        this.quantity=quantity;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    void changeQuantity(int newQ){
        this.quantity=newQ;
    }

    public boolean availability(){
        if(quantity<1)return false;
        else return true;
    }
}