package model.stream;

public class Promotion {
    private String name;
    private long timestamp;
    private long duration;  // in milliseconds
    private double percent;

    public Promotion(String name, long timestamp, long duration, double percent) {
        this.name = name;
        this.timestamp = timestamp;
        this.duration = duration;
        this.percent = percent;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getDuration() {
        return duration;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
