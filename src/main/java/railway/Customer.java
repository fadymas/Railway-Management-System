package railway;

import java.awt.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

public class Customer extends User {
    private Address address;
    private int phoneNumber;
    private int age;

    public Customer(String email, String firstname, String lastname, String password,  int phoneNumber,
            int age,String street, String city, String state, int zip) {
        super(email, firstname, lastname, password);
        this.address = new Address(street,city,state,zip);
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Customer() {
    }

    public Customer(String email, String password) {
        super(email, password);
    }

    @SuppressWarnings({ "deprecation", "rawtypes" })
    public void registrar(Files file, JFrame frame) {

        HashMap<String, HashMap> customers = new HashMap<String, HashMap>();
        customers = file.loadCustomer(customers);
        HashMap<String, Object> customerInfo = new HashMap<String, Object>();
        if (customers.containsKey(email)) {
            JOptionPane.showMessageDialog(frame, "Email already exists");
        } else {
            customerInfo.put("FirstName", firstname);
            customerInfo.put("LastName", lastname);
            customerInfo.put("Password", password);
            customerInfo.put("City", address.getCity());
            customerInfo.put("State", address.getState());
            customerInfo.put("Street", address.getStreet());
            customerInfo.put("PhoneNumber", phoneNumber);

            customerInfo.put("age", age);

            customers.put(email, customerInfo);
            try {

                file.saveCustomer(customers);
            } catch (Exception e1) {
                e1.printStackTrace();

            }
            JOptionPane.showMessageDialog(frame, "Customer successfully registered");
        }
    }

    public void login(JFrame frame, Files file) throws Exception {

        HashMap<String, HashMap> customers = new HashMap<String, HashMap>();
        customers = file.loadCustomer(customers);

        if (customers.containsKey(email)) {
            HashMap<String, Object> Usersinfo = customers.get(email);
            if (Usersinfo.containsValue(password)) {
                Main main = new Main();
                main.Book();
                frame.dispose();

            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Password");
            }

        } else {
            JOptionPane.showMessageDialog(frame, "Invalid Email");
        }}

    

    

    

    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void logout(JFrame frame,JFrame bigframe) {
        frame.dispose();
        bigframe.dispose();
        Main.main(null);
    }

 public void search(JTable table, Files file, DefaultTableModel tableModel, JDateChooser dateField, JComboBox fromComboBox, JComboBox toComboBox) {
    HashMap<String, HashMap> tickets = new HashMap<String, HashMap>();
    try {
        tickets = file.LoadTicket(tickets);
    } catch (Exception e1) {
        e1.printStackTrace();
    }

    // Clear the table
    tableModel.setRowCount(0);

    String froms = null;
    String tos = null;
    boolean isMatchFound = false;
    // Iterate over the tickets
    for (HashMap<String, HashMap> ticketCategory : tickets.values()) {
        for (Entry<String, HashMap> entry : ticketCategory.entrySet()) {

            String ticketId = entry.getKey(); // This is your ticket ID
            HashMap<String, Object> ticket = entry.getValue();
            // Get the "From", "To", and "Date" field values
            froms = (String) ticket.get("From");
            tos = (String) ticket.get("To");
            String dates = ticket.get("Date").toString();
            String ticketseat = ticket.get("Seat").toString();
            int ticketprice = (int) ticket.get("Price");
            String tripDepartureTime = ticket.get("Departure Time").toString();
            int tripNumber = (int) ticket.get("Trip Number");
            String TicketType = ticket.get("Ticket Type").toString();
            Date date = (Date) dateField.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = null;
            String tripduration = null;
            try {
                formattedDate = formatter.format(date);
                tripduration = ticket.get("Duration").toString();
            } catch (Exception e) {
            }

            // If the ticket matches the selected values, add it to the table
            if (froms.equals(fromComboBox.getSelectedItem().toString())
                    && tos.equals(toComboBox.getSelectedItem().toString()) && dates.equals(formattedDate)) {
                tableModel.addRow(new Object[]{ticketId, TicketType, ticketprice, ticketseat, froms, tos, dates,
                        tripNumber, tripDepartureTime, tripduration});
                isMatchFound = true; // Add this line
            }
        }
    }
    if (!isMatchFound) {
        JOptionPane.showMessageDialog(null, "No Ticket has been founded");
    }
}

public void selectitem(DefaultTableModel tableModel,Files file,String elem) {
    
        HashMap<String, HashMap<String, Object>> tickets = new HashMap<>();
try {
    tickets = file.LoadTicket(tickets);
} catch (Exception e1) {
    e1.printStackTrace();
}

tableModel.setRowCount(0);
String trainName = null;

for (String train : tickets.keySet()) {
    if (train.equals(elem)) {
        trainName = train;
        HashMap<String, Object> ticketCategory = tickets.get(train);
        for (Map.Entry<String, Object> entry : ticketCategory.entrySet()) {
            HashMap<String, Object> ticket = (HashMap<String, Object>) entry.getValue();
            if (trainName.equals(elem)) {
                String ticketId = entry.getKey();
                String from = (String) ticket.get("From");
                String to = (String) ticket.get("To");
                String date = ticket.get("Date").toString();
                String seat = ticket.get("Seat").toString();
                int price = (int) ticket.get("Price");
                String departureTime = ticket.get("Departure Time").toString();
                int tripNumber = (int) ticket.get("Trip Number");
                String ticketType = ticket.get("Ticket Type").toString();
                String duration = ticket.get("Duration").toString();
                tableModel.addRow(new Object[]{ticketId, ticketType, price, seat, from, to, date, tripNumber, departureTime, duration});
            }
        }
    }
}
        
    
   } 
    public void Book( JTable table,Files file,DefaultTableModel tableModel) {
        int[] selectedRows = table.getSelectedRows();
    if (selectedRows.length > 0) {
        // Check if the first row is selected
       
        int totalPrice = 0;
        
        for (int selectedRow : selectedRows) {
            for (int i = 0; i < table.getColumnCount(); i++) {
                
                if (table.getColumnName(i).equals("Ticket Price")) {
                    totalPrice += (int) table.getValueAt(selectedRow, i);
                }
            }
        }
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "The total price: " + totalPrice + ", do you want to buy?", "Confirm Purchase", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
             StringBuilder detailss = new StringBuilder();
// Append details to detailss
        
      for (int selectedRow : selectedRows) {
        detailss.append("\t\t\t\tTicket Details: ");
        detailss.append("\n------------------------\n");
        for (int i = 0; i < table.getColumnCount(); i++) {
          detailss.append(table.getColumnName(i)).append(": ").append(table.getValueAt(selectedRow, i)).append("\n");

        }

      }
      detailss.append("\n");
      detailss.append("------------------------------------------------------");
        detailss.append("\nTotal Price :"+totalPrice);

             
     Document document = new Document();
    try {
        PdfWriter.getInstance(document, new FileOutputStream("TicketDetails.pdf"));
        document.open();
        document.add(new Paragraph(detailss.toString()));
        document.close();
        JOptionPane.showMessageDialog(null, "Thank you ");

      
      } catch (Exception ex) {

      }
      
    
    
       
        HashMap<String,HashMap> remtickets = new HashMap<String,HashMap>();
    
    
       
        try {
        remtickets = file.LoadTicket(remtickets);
         StringBuilder detailsss = new StringBuilder();
    // Append details to detailss
        for (int selectedRow : selectedRows) {
          detailsss.append("\t\t\t\tTicket Details: ");
          detailsss.append("\n------------------------\n");
          for (int i = 0; i < table.getColumnCount(); i++) {
            detailsss.append(table.getColumnName(i)).append(": ").append(table.getValueAt(selectedRow, i)).append("\n");
            if (table.getColumnName(i).equals("Ticket ID")) {
              String ticketId = (String) table.getValueAt(selectedRow, i);
              for (HashMap<String, HashMap> ticketCategory : remtickets.values()) {
                if (ticketCategory.containsKey(ticketId)) {
                  ticketCategory.remove(ticketId);
                }
              }
            }
          }
        }
        file.SaveTicket(remtickets);
        
        tableModel.setRowCount(0);
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        } else {
            // Code to execute when the user clicks "No"
        }
    } else {
         JOptionPane.showMessageDialog(null, "No row is selected.");
    }
        
        
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}