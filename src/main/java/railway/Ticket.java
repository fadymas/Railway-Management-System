package railway;

public class Ticket {
    private int ticketID;
    private String ticketType;
    private Train train;
    private String seat;
    private Trip trip;
    private int price;

    public Ticket(int ticketID, String ticketType, Train train, String seat, int price, Trip trip) {
        this.ticketID = ticketID;
        this.ticketType = ticketType;
        this.train = train;
        this.seat = seat;
        this.trip = trip;

        this.price = price;
    }
    public Ticket(int ticketID, String ticketType,  String seat, int price,Trip trip) {
        this.ticketID = ticketID;
        this.ticketType = ticketType;
        
        this.seat = seat;
        this.trip = trip;
        
        this.price = price;
    }

    public int getTicketID() {
        return ticketID;
    }



    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Train getTrain() {
        return train;
    }
    

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}