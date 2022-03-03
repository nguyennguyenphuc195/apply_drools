package model;

import java.util.HashMap;

public class Result {
    public HashMap<String, Integer> parity2count;
    private int count;

    public Result() {
        parity2count = new HashMap<>();
        parity2count.put("odd", 0);
        parity2count.put("even", 0);
    }

    public void increment(String k) {
        parity2count.replace(k, parity2count.get(k) + 1);
    }


}
