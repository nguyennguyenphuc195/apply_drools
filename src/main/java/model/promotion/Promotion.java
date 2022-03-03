package model.promotion;

public class Promotion {
    int id;
    int []idAffects;
    String name;
    double percent;

    public Promotion(int id, int[] idAffects, String name, double percent) {
        this.id = id;
        this.idAffects = idAffects;
        this.name = name;
        this.percent = percent;
    }

    public int[] getIdAffects() {
        return idAffects;
    }

    public String getName() {
        return name;
    }

    public double getPercent() {
        return percent;
    }

    public void setIdAffects(int[] idAffects) {
        this.idAffects = idAffects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
