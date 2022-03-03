package model.fibonacci;

import java.math.BigInteger;

public class Fibonacci {
    long value = -1;
    int sequence;

    public Fibonacci(int sequence) {
        this.sequence = sequence;
    }

    public long getValue() {
        return value;
    }

    public int getSequence() {
        return sequence;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
