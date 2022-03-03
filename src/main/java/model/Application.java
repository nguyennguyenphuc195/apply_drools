package model;

import java.util.Date;

public class Application {
    private Date dateApplied;
    private boolean valid;
    // Getter and setter methods

    public Application() {
    }

    public Application(Date dateApplied, boolean valid) {
        this.dateApplied = dateApplied;
        this.valid = valid;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public boolean isValid() {
        return valid;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}