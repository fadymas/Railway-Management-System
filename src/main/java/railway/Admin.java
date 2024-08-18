package railway;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

public class Admin extends User {
   
   
    private int adminId;
    
   

    public Admin(int adminId, String email, String firstname, String lastname, String password) {
        super(email, firstname, lastname, password);
        this.adminId = adminId;
    }

    public Admin() {

    }

    public Admin(int id){
        adminId = id;
    }

    public Admin(String email, String password, int adminId) {
        super(email, password);
        this.adminId = adminId;
        
    }

   
    
    @SuppressWarnings({ "deprecation", "rawtypes" })
    public void registrar(Files file)   {
      
        
            HashMap<String, Object> Usersinfo = new HashMap<String, Object>();
            HashMap<String, HashMap> admins = new HashMap<String, HashMap>();
        
            admins = file.loadAdmin(admins);
            
            
        
        Usersinfo.put("FirstName", firstname);
        Usersinfo.put("LastName", lastname);
        Usersinfo.put("Password", password);
        Usersinfo.put("AdminId", adminId);
        admins.put(email, Usersinfo);
        
            try {
           
                    file.saveAdmin(admins);
                    
         JOptionPane.showMessageDialog(null, "Admin successfully registered");
            
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Id is only number");
            
        }
                
            
                
        
        
        
        
        
       
        
        
        
        
        
    }
    @SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
    public void login(JFrame frame,Files file){
            
            HashMap<String, HashMap> admins = new HashMap<String, HashMap>();
            admins = file.loadAdmin(admins);
            
            
            
            if (admins.containsKey(email)) {
                HashMap<String, Object> Usersinfo = admins.get(email);
                if (Usersinfo.containsValue(password)) {
                    
                    if (Usersinfo.containsValue(adminId)) {
                        frame.dispose();
                        Main main = new Main();
                        main.Adminwork(file);
                        
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Invalid AdminId");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Password");
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Invalid Email");
            }
            
            
            
        
        

        
        
            
                
        
        
          
           
       
        

        
        }

        public void logout(JFrame frame, JFrame bigframe) {
        bigframe.dispose();
        frame.dispose();
        Main.main(null);
    }

    public void confirmAdminId(Files file,JDialog dialog,JFrame frame){
        HashMap<String, HashMap> admins = new HashMap<String, HashMap>();
                admins = file.loadAdmin(admins);
                int i = 0;
                if (admins.isEmpty() && adminId== 123) {
                    dialog.dispose();
                     Main main = new Main();
                     JFrame adminreg = main.AdminRegistrar();
                            adminreg.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowOpened(WindowEvent e) {

                                    frame.setEnabled(false);
                                }

                                @Override
                                public void windowClosed(WindowEvent e) {
                                    frame.setEnabled(true);
                                }
                            });
                }
                else {
                   for (HashMap<String, Object> elem : admins.values()) {

                        if ((elem.get("AdminId")).equals(adminId)) {
                            dialog.dispose();
                            Main main = new Main();
                            JFrame adminreg = main.AdminRegistrar();
                            adminreg.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowOpened(WindowEvent e) {

                                    frame.setEnabled(false);
                                }

                                @Override
                                public void windowClosed(WindowEvent e) {
                                    frame.setEnabled(true);
                                }
                            });
                            i++;
                        }

                    }
                    if (i == 0) {
                        JOptionPane.showMessageDialog(frame, "Invalid AdminId");
                    } 
                }
                
        
        
    }

    public Ticket addTicket(Ticket ticket,Trip trip,Files file,JFrame addTicketframe,JComboBox seatoftrain) {
        
        
         
       
        
                               
                                    
                                    HashMap<Object, HashMap> Categories = new HashMap<Object, HashMap>();
                                    HashMap<String, HashMap> removeseat = new HashMap<String, HashMap>();
                                    removeseat = file.loadTrains(removeseat);
                                    
                                    
                                    try {
                                        Categories = file.LoadTicket(Categories);
                                        
                                         
                                    } catch (Exception e1) {
                                        
                                    }
                                    
                                    HashMap<Object, HashMap> items;
                                    try {
                                        if (Categories.get(ticket.getTrain().getName()).size()==0) {
                                        items = new HashMap<Object, HashMap>();
                                    } else {
                                    items = Categories.get(ticket.getTrain().getName());
                                  }
                              } catch (Exception x) {
                                  items = new HashMap<Object, HashMap>();
                              }
                              
                                      
                                    if (items.containsKey(String.valueOf(ticket.getTicketID()))) {
                                    
                                        JOptionPane.showMessageDialog(null, "Ticket Already Exists");
                                    } else {
                                        HashMap<String, Object> item = new HashMap<String, Object>();

                                        try {

                                            item.put("Ticket Type", (ticket.getTicketType()));
                                            item.put("Price", ticket.getPrice());
                                            item.put("Seat", ticket.getSeat());
                                           
                                            item.put("Trip Number", trip.getTripNumber());
                                            item.put("From", trip.getFrom().getName().toLowerCase());
                                            item.put("To", trip.getTo().getName().toLowerCase());
                                            Date date = trip.getDepartureDate();
                                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                                            String formattedDate = formatter.format(date);
                                            item.put("Date", formattedDate);

                                            // Assuming the time is an array of hour, minute, second, nanosecond
                                           LocalTime time = trip.getDepartureTime();
                                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                            String formattedTime = time.format(timeFormatter);
                                            item.put("Departure Time", formattedTime);
                                            
                                            item.put("Duration", trip.getDuration());

                                            items.put(ticket.getTicketID(), item);
                                            Categories.put(ticket.getTrain().getName(), items);
                                            
                                             for (HashMap<String, Object> big : removeseat.values()) {
                                                if (big.get("TrainName")
                                                        .equals(ticket.getTrain().getName())) {
                                                    ArrayList<String> seats = (ArrayList<String>) (big.get("Seats"));
                                                    for (String reseat : seats) {
                                                        if (reseat.equals(ticket.getSeat())) {
                                                            seats.remove(seats.indexOf(reseat));
                                                            big.put("Seats", seats);
                                                            seatoftrain.removeAllItems();

                                                            

                                                            break;
                                                        }
                                                    }
                                                }

                                            }
                                            
                                            file.SaveTicket(Categories);
                                            file.saveTrain(removeseat);

                                            JOptionPane.showMessageDialog(null, "Ticket Added");
                                            addTicketframe.validate();
                                            addTicketframe.repaint();
                                        } catch (Exception e1) {
                                            JOptionPane.showMessageDialog(addTicketframe, "Ticket Exception");
                                        }

                                    }
                               
                                
        


        
                                    return ticket;
        
                                }

    public void removeTicket(Files file, JFrame frame, Ticket ticket) {

                                    HashMap<String, HashMap> tickets = new HashMap<String, HashMap>();
                                    try {
                                        tickets = file.LoadTicket(tickets);
                                    } catch (Exception ex) {
                                    }

                                    int i = 0;
                                    boolean trainFound = false;
                                    try {
                                        for (String trainName : tickets.keySet()) {
                                            HashMap<String, HashMap> ticketsinfo = tickets.get(trainName);
                                            if (trainName.equals(ticket.getTrain())) {
                                                trainFound = true;
                                                if (ticketsinfo.containsKey(String.valueOf(ticket.getTicketID()))) {
                                                    ticketsinfo.remove(String.valueOf(ticket.getTicketID()));
                                                    JOptionPane.showMessageDialog(frame, "Success");

                                                    try {
                                                        file.SaveTicket(tickets);
                                                    } catch (Exception e1) {
                                                    }
                                                    i++;
                                                } else {
                                                    JOptionPane.showMessageDialog(frame, "Invalid Ticket Id");
                                                    break;
                                                }
                                            }
                                        }
                                        if (!trainFound) {
                                            JOptionPane.showMessageDialog(frame, "Invalid Train Name");
                                        }
                                    } catch (Exception z) {
                                    }

                                }
    
    public void editTicket(Files file, JFrame frame,Ticket ticket,Trip trip,JComboBox seatsoftrain) {
       
                           

                                HashMap<String, HashMap> Categories = new HashMap<String, HashMap>();
                                HashMap<String, HashMap> removeseat = new HashMap<String, HashMap>();
                                removeseat = file.loadTrains(removeseat);

                                try {
                                    Categories = file.LoadTicket(Categories);

                                } catch (Exception e1) {

                                }

                                HashMap<String, HashMap> items;
                                try {
                                    if (Categories.get(ticket.getTrain()).size() == 0) {
                                        items = new HashMap<String, HashMap>();
                                    } else {
                                        items = Categories.get(ticket.getTrain());
                                    }
                                } catch (Exception x) {
                                    items = new HashMap<String, HashMap>();
                                }

                                HashMap<String, Object> item = new HashMap<String, Object>();

                                try {

                                    item.put("Price", ticket.getPrice());
                                    item.put("Seat", ticket.getSeat());
                                    for (HashMap<String, Object> big : removeseat.values()) {
                                        if (big.get("TrainName")
                                                .equals(ticket.getSeat())) {
                                            ArrayList<String> seats = (ArrayList<String>) (big.get("Seats"));
                                            for (String seat : seats) {
                                                if (seat.equals(ticket.getSeat())) {
                                                    seats.remove(seats.indexOf(seat));

                                                    big.put("Seats", seats);

                                                    seatsoftrain.removeAllItems();

                                                    break;
                                                }
                                            }
                                        }

                                    }
                                    item.put("Trip Number", trip.getTripNumber());
                                    item.put("From",trip.getFrom().getName());
                                    item.put("To", trip.getTo().getName());
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    String dateString = dateFormat.format(trip.getDepartureDate());
                                    item.put("Date", dateString);

                                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                                    String timeString = timeFormat.format(trip.getDepartureTime());
                                    item.put("Departure Time", timeString);

                                    items.put(String.valueOf(ticket.getTicketID()), item);
                                    Categories.put(ticket.getTrain().getName(), items);
                                    file.SaveTicket(Categories);
                                    file.saveTrain(removeseat);

                                    JOptionPane.showMessageDialog(frame, "Ticket Added");
                                    frame.validate();
                                    frame.repaint();
                                } catch (Exception e1) {
                                    JOptionPane.showMessageDialog(frame, "Ticket Exception");
                                }

                            
    }
    public void addTrain(Files file,JFrame frame,Train train) {

                                
                            
                               
                                
                                    HashMap<String, Object> trainsinfo = new HashMap<String, Object>();
                                    HashMap<String, HashMap> trains = new HashMap<String, HashMap>();
                                    trains = file.loadTrains(trains);
                                    if (trains.containsKey(String.valueOf(train.getId()))) {
                                        JOptionPane.showMessageDialog(frame, "Train Already Exists");
                                    } else {

                                        try {
                                            

                                            trainsinfo.put("TrainName", train.getName());
                                            trainsinfo.put("Capacity", train.getCapacity());
                                            trainsinfo.put("Seats", train.getSeats());
                                            trains.put(String.valueOf(train.getId()), trainsinfo);
                                            file.saveTrain(trains);
                                              ArrayList<Train> trainscate;
                                            
                                                 trainscate = file.loadCategory();
                                            
                                           
                                            
                                            Category category = new Category(trainscate);
                                            category.setTrainCategoryes(train,file);

                                            JOptionPane.showMessageDialog(frame,
                                                    "Train added successfully");

                                        } catch (Exception e1) {
                                            JOptionPane.showMessageDialog(frame, "Id is only number");

                                        }

                                    }
                                
                               
        
    }
    @SuppressWarnings("unlikely-arg-type")
    public void removeTrain(Files file, JFrame frame ,Train train) {

        HashMap<String, HashMap> trains = new HashMap<String, HashMap>();
            HashMap<String, HashMap> tickets = new HashMap<String, HashMap>();
            try {
                tickets = file.LoadTicket(tickets);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            trains = file.loadTrains(trains);
            int i = 0;
            try {
                for (String trainid : trains.keySet()) {
                    HashMap<String, String> trainname = trains.get(trainid);
                    if (trainid.equals(String.valueOf( train.getId()))) {

                        trains.remove(trainid);
                        ArrayList<Train> trainList = file.loadCategory();
                                        
                    
                                        
                                        Category category = new Category(trainList);
                                        category.removetrainformca(train, file);
                         JOptionPane.showMessageDialog(frame, "Success");
                                try {
                                    file.saveTrain(trains);
                                    

                                } catch (Exception e1) {
                                }
                        for (Object elem : tickets.keySet()) {
                            if (trainname.get("TrainName").equals(elem)) {

                                tickets.remove(elem);
                                 try {
                                    
                                    file.SaveTicket(tickets);

                                } catch (Exception e1) {
                                }
                               
                            }

                        }

                        i++;
                    }
                }

                if (i == 0) {
                    JOptionPane.showMessageDialog(frame, "Invalid Train Id");
                }
            } catch (Exception z) {

            }
    }

    public void editTrain(Files file,JFrame frame,Train train) {
                    HashMap<String, Object> trainsinfo = new HashMap<String, Object>();
                                            HashMap<String, HashMap> trainss = new HashMap<String, HashMap>();
                                            trainss = file.loadTrains(trainss);

                                            try {
                                                
                                                
                                                
                                                

                                                trainsinfo.put("TrainName", train.getName());
                                                trainsinfo.put("Capacity", train.getCapacity());
                                                trainsinfo.put("Seats", train.getSeats());
                                                trainss.put(String.valueOf(train.getId()), trainsinfo);
                                                file.saveTrain(trainss);

                                                JOptionPane.showMessageDialog(frame,
                                                        "Train added successfully");

                                            } catch (Exception e1) {
                                                JOptionPane.showMessageDialog(frame, "Id is only number");

                                            }

        
                            
 }
    public void removeCustomer(Files file,JDialog frame,Customer customer) {
        
                HashMap<String, HashMap> customers = new HashMap<String, HashMap>();
                customers = file.loadCustomer(customers);
                int i = 0;
                for (String email: customers.keySet()) {
                    if (email.equals(customer.email)) {
                        
                        customers.remove(email);
                        JOptionPane.showMessageDialog(frame, "Success");
                        try {
                            file.saveCustomer(customers);

                        } catch (Exception e1) {
                            
                        }
                        i++;
                    }
                }

                
                if (i == 0) {
                        JOptionPane.showMessageDialog(frame, "Invalid Email");
                    }
                
            
            
              
            

            
 
   
   
   
   
   
                    

            


    }
    public void removeAdmin(Files file,JFrame frame) {
         
           
                 HashMap<String, HashMap> admins = new HashMap<String, HashMap>();
                admins = file.loadAdmin(admins);
                int i = 0;
                for (String email: admins.keySet()) {
                HashMap<String, Object> elem = admins.get(email);
                
                
                   
                    if ((elem.get("AdminId")).equals(adminId)) {
                        
                        admins.remove(email);
                        try {
                            file.saveAdmin(admins);
                            JOptionPane.showMessageDialog(frame, "Success");
                        } catch (Exception e1) {
                        }
                        i++;
                    }
                }

                
                if (i == 0) {
                        JOptionPane.showMessageDialog(frame, "Invalid AdminId");
                    }
                
            
              
            

            
 
   
   
   
   
   
                    

            

    }

    public void viewTrains(Files file) {
        Main main = new Main();
        main.viewTrains(file);
    }
    public void viewTickets(Files file) {
        Main main = new Main();
        main.viewTickets(file);
    }
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    
}
