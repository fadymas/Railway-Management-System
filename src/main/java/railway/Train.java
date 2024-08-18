package railway;

import java.io.Serializable;
import java.util.ArrayList;

public class Train implements Serializable {
    private String name;
    private int id;
    private int capacity;
    private ArrayList<String> seats;
    

    public Train(int capacity, int id, String name, ArrayList<String> seats) {
        this.capacity = capacity;
        this.id = id;
        this.name = name;
        this.seats = seats;
    }
     public Train(int capacity, int id, String name, ArrayList<String> seats,Category category) {
        this.capacity = capacity;
        this.id = id;
        this.name = name;
        this.seats = seats;
        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public ArrayList<String> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<String>seats) {
            this.seats = seats;
            for (int i = 1; i <= getCapacity(); i++) {
            
                
            String seatnum = String.format("SeatNo %d", i);

            seats.add(seatnum);
            
            
        }
            
    
        
        
        }
    }

