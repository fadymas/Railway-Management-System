package railway;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Files {

     public void saveCategory(ArrayList<Train> trainscate) {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/trainscate.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(trainscate);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Train> loadCategory() {
        ArrayList<Train> trainscate = null;
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/trainscate.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            trainscate = (ArrayList<Train>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            trainscate = new ArrayList<Train>();
        } catch (ClassNotFoundException c) {
            trainscate = new ArrayList<Train>();
            
        }
        return trainscate;
    }

    @SuppressWarnings("rawtypes")
    public void saveCustomer(HashMap<String, HashMap> customers) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customers);

            try (PrintWriter writer = new PrintWriter(
                    "src/main/resources/Customers.json")) {
                writer.println(json);
                writer.close();
            }

        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public HashMap<String, HashMap> loadCustomer(HashMap<String, HashMap> customers) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            File jsonFile = new File("src/main/resources/Customers.json");

            customers = mapper.readValue(jsonFile, HashMap.class);

            return customers;

        } catch (IOException e) {

            customers = new HashMap();

        }
        return customers;

    }

    @SuppressWarnings("rawtypes")
    public void saveAdmin(HashMap<String, HashMap> admins) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(admins);

            try (PrintWriter writer = new PrintWriter("src/main/resources/Admins.json")) {
                writer.println(json);
                writer.close();
            }

        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public HashMap<String, HashMap> loadAdmin(HashMap<String, HashMap> admins) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            File jsonFile = new File("src/main/resources/Admins.json");

            admins = mapper.readValue(jsonFile, HashMap.class);

            return admins;

        } catch (IOException e) {

            admins = new HashMap();

        }
        return admins;

    }

    public void SaveTicket(HashMap Categories) throws Exception {

        ObjectMapper mapper;

        try {

            mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(Categories);
            
            PrintWriter writer = new PrintWriter(
                    "src/main/resources/Tickets.json");
            writer.println(json);
            writer.close();

        } catch (JsonProcessingException e) {
            System.out.println(e);
            return;
        }

    }

    public HashMap LoadTicket(HashMap Categories) throws Exception {

        ObjectMapper mapper;

        try {
            mapper = new ObjectMapper();

            File jsonFile = new File("src/main/resources/Tickets.json");

            Categories = mapper.readValue(jsonFile, HashMap.class);

        } catch (Exception e) {

            Categories = new HashMap<String, Object>();

        }
        return Categories;
    }

    public void saveTrain(HashMap<String, HashMap> trains) throws FileNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trains);

            try (PrintWriter writer = new PrintWriter("src/main/resources/Trains.json")) {
                writer.println(json);
                writer.close();
            }

        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

    }

    public HashMap<String, HashMap> loadTrains(HashMap<String, HashMap> trains) {

        ObjectMapper mapper = new ObjectMapper();
     mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        try {

            File jsonFile = new File("src/main/resources/Trains.json");

            trains = mapper.readValue(jsonFile, HashMap.class);

            return trains;

        } catch (IOException e) {

            trains = new HashMap();

        }
        return trains;
}

}


