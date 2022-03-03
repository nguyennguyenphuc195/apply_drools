package model.stream;

import java.util.Date;

public class VoiceCall {
    private String  originNumber;
    private String  destinationNumber;
    private Date callDateTime;
    private long callDuration;  // in milliseconds

    public VoiceCall(String originNumber, String destinationNumber, Date callDateTime, long callDuration) {
        this.originNumber = originNumber;
        this.destinationNumber = destinationNumber;
        this.callDateTime = callDateTime;
        this.callDuration = callDuration;
    }

    public void setOriginNumber(String originNumber) {
        this.originNumber = originNumber;
    }

    public void setDestinationNumber(String destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    public void setCallDateTime(Date callDateTime) {
        this.callDateTime = callDateTime;
    }

    public void setCallDuration(long callDuration) {
        this.callDuration = callDuration;
    }

    public String getOriginNumber() {
        return originNumber;
    }

    public String getDestinationNumber() {
        return destinationNumber;
    }

    public Date getCallDateTime() {
        return callDateTime;
    }

    public long getCallDuration() {
        return callDuration;
    }
}
