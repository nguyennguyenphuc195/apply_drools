package model.stream;

import java.util.Date;

public class Event {
    private String name;
    private long timestamp;
    private double price;
    private double salePrice;


    public Event(String name, long timestamp, double price) {
        this.name = name;
        this.timestamp = timestamp;
        this.price = price;
        this.salePrice = -1;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
