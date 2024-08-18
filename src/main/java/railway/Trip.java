package railway;

import java.time.LocalTime;
import java.util.Date;

public class Trip {
    private int tripNumber;
    private Station from;
    private Station to;
    private Date departureDate;
    private LocalTime departureTime;
    private int duration;
    public Trip(int tripNumber, Station from, Station to, Date departureDate, LocalTime departureTime,
            int duration) {
        this.tripNumber = tripNumber;
        this.from = from;
        this.to = to;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.duration = duration;
    }
    public int getTripNumber() {
        return tripNumber;
    }
    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }
    public Station getFrom() {
        return from;
    }
    public void setFrom(Station from) {
        this.from = from;
    }
    public Station getTo() {
        return to;
    }
    public void setTo(Station to) {
        this.to = to;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public LocalTime getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
