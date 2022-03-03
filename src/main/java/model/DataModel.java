package model;

public class DataModel {
    int data;
    int square;

    public void setIsEven(int isEven) {
        this.isEven = isEven;
    }

    public int getIsEven() {
        return isEven;
    }

    int isEven;


    public DataModel(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "data=" + data +
                ", square=" + square +
                ", isEven=" + isEven +
                '}';
    }
}
