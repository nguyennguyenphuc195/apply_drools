package model.promotion;

import java.util.ArrayList;
import java.util.List;

public class Product {
    int id;
    String name;
    double price;
    double salePrice;
    List<Promotion> appliedPromotions;
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.salePrice = price;
        this.appliedPromotions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                '}';
    }
}
