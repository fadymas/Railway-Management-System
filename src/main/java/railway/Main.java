package railway;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.util.Map;
import com.toedter.calendar.JDateChooser;

public class Main {
    public JFrame CustomerRegistrar() {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBounds(0, 0, 500, 500);
        JLabel emaillabel = new JLabel(" Entar your Email:");
        emaillabel.setBounds(18, 0, 200, 60);
        frame.add(emaillabel);

        JLabel fristlabel = new JLabel(" Entar your first name:");
        fristlabel.setBounds(18, 30, 200, 60);
        frame.add(fristlabel);

        JTextField fristText = new JTextField(20);
        fristText.setBounds(300, 50, 165, 25);
        frame.add(fristText);

        JLabel lastlabel = new JLabel(" Entar your last name:");
        lastlabel.setBounds(18, 60, 200, 60);
        frame.add(lastlabel);

        JTextField lastText = new JTextField(20);
        lastText.setBounds(300, 80, 165, 25);
        frame.add(lastText);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(300, 20, 165, 25);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Entar your password:");
        passwordLabel.setBounds(20, 110, 200, 25);
        frame.add(passwordLabel);

        JPasswordField passwordtext = new JPasswordField();
        passwordtext.setBounds(300, 113, 165, 25);
        frame.add(passwordtext);

        JLabel cityJLabel = new JLabel(" Entar your City:");
        cityJLabel.setBounds(17, 125, 200, 60);
        frame.add(cityJLabel);

        JTextField cityField = new JTextField();
        cityField.setBounds(300, 145, 165, 25);
        frame.add(cityField);

        JLabel stateLabel = new JLabel(" Entar your State:");
        stateLabel.setBounds(17, 163, 200, 60);
        frame.add(stateLabel);

        JTextField stateField = new JTextField();
        stateField.setBounds(300, 180, 165, 25);
        frame.add(stateField);

        JLabel streetLabel = new JLabel(" Entar your Street:");
        streetLabel.setBounds(17, 200, 200, 60);
        frame.add(streetLabel);

        JTextField streetField = new JTextField();
        streetField.setBounds(300, 220, 165, 25);
        frame.add(streetField);

        JLabel number = new JLabel("Entar your phone Number:");
        number.setBounds(20, 240, 200, 60);
        frame.add(number);

        JTextField numberTextField = new JTextField();
        numberTextField.setBounds(300, 260, 165, 25);
        frame.add(numberTextField);

        JLabel ageLabel = new JLabel("Select your Age:");
        ageLabel.setBounds(20, 310, 200, 60);
        frame.add(ageLabel);

        Integer[] ageOptions = new Integer[80];
        for (int i = 0; i < 80; i++) {
            ageOptions[i] = i + 18;
        }
        JComboBox<Integer> ageComboBox = new JComboBox<>(ageOptions);
        ageComboBox.setBounds(300, 330, 165, 25);
        frame.add(ageComboBox);

        JLabel zip = new JLabel("Entar your ZipCode:");
        zip.setBounds(20, 275, 200, 60);
        frame.add(zip);

        JTextField zipField = new JTextField();
        zipField.setBounds(300, 295, 165, 25);
        frame.add(zipField);

        JButton registrarButton = new JButton("Register");
        registrarButton.setBounds(200, 400, 100, 25);
        registrarButton.setFocusable(false);
        frame.add(registrarButton);
        registrarButton.addActionListener(e -> {
            if (emailField.getText().contains("@") && emailField.getText().length() > 5) {
                try {

                    Customer customer = new Customer(emailField.getText(), fristText.getText(), lastText.getText(),
                            passwordtext.getText(),
                            Integer.parseInt(numberTextField.getText()), (int) ageComboBox.getSelectedItem(),
                            stateField.getText(), cityField.getText(), stateField.getText(),
                            Integer.parseInt(zipField.getText()));
                    Files file = new Files();
                    customer.registrar(file, frame);
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Please Enter All details with normal form");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email");
            }

        });

        frame.setLayout(null);
        frame.setTitle("Registration");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(imageIcons.getImage());
        frame.setVisible(true);
        return frame;

    }

    public JPanel CustomerLogin(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setBounds(0, 250, 750, 500);

        JLabel emaillabel = new JLabel("Email:");
        emaillabel.setBounds(250, 90, 80, 60);
        panel.add(emaillabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(350, 100, 200, 40);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(250, 190, 80, 60);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(350, 200, 200, 40);
        panel.add(passwordText);

        JButton Loginbutton = new JButton("Login");
        Loginbutton.setBounds(230, 300, 100, 40);
        panel.add(Loginbutton);
        Loginbutton.setBounds(230, 300, 100, 40);
        panel.add(Loginbutton);
        Loginbutton.addActionListener(e -> {
            Customer customer = new Customer(emailField.getText(), passwordText.getText());
            Files file = new Files();
            try {
                customer.login(frame, file);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });

        JButton registrarbutton = new JButton("registrar");
        registrarbutton.setBounds(450, 300, 100, 40);
        panel.add(registrarbutton);
        registrarbutton.addActionListener(e -> {
            JFrame cusreg = CustomerRegistrar();

            cusreg.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent s) {
                    frame.setEnabled(false);
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    frame.setEnabled(true);

                }

            });
        });

        return panel;
    }

    public JFrame AdminRegistrar() {
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setSize(500, 300);
        JLabel emaillabel = new JLabel(" Entar your Email:");
        emaillabel.setBounds(18, 0, 200, 60);
        frame.add(emaillabel);
        JLabel firstlabel = new JLabel(" Entar your FirstName:");
        firstlabel.setBounds(18, 60, 200, 60);
        frame.add(firstlabel);
        JLabel lastlabel = new JLabel(" Entar your LastName:");
        lastlabel.setBounds(18, 120, 200, 60);
        frame.add(lastlabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(280, 10, 200, 40);
        frame.add(emailField);
        JTextField firstField = new JTextField();
        firstField.setBounds(280, 70, 200, 40);
        frame.add(firstField);
        JTextField lastField = new JTextField();
        lastField.setBounds(280, 130, 200, 40);
        frame.add(lastField);
        JLabel passLabel = new JLabel("Enter your Passwords:");
        passLabel.setBounds(18, 180, 200, 60);
        frame.add(passLabel);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(280, 190, 200, 40);
        frame.add(passField);
        JLabel adminIdLabel = new JLabel("Enter AdminId;");
        adminIdLabel.setBounds(18, 240, 200, 60);
        frame.add(adminIdLabel);
        JTextField adminIdField = new JTextField();
        adminIdField.setBounds(280, 250, 200, 40);
        frame.add(adminIdField);
        JButton registrarButton = new JButton("Register");
        registrarButton.setBounds(200, 400, 100, 25);
        registrarButton.setFocusable(false);
        frame.add(registrarButton);
        registrarButton.addActionListener(e -> {
            try {
                if (!emailField.getText().contains("@") && emailField.getText().length() > 5) {
                    JOptionPane.showMessageDialog(frame, "Invalid Email");
                } else {
                    Admin admin = new Admin(Integer.parseInt(adminIdField.getText()), emailField.getText(),
                            firstField.getText(), lastField.getText(), passField.getText());
                    Files file = new Files();
                    admin.registrar(file);
                }
            } catch (Exception h) {
                JOptionPane.showMessageDialog(null, "Please Enter All details with normal form");
            }

        });
        frame.setLayout(null);
        frame.setTitle("Registration");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(imageIcons.getImage());
        frame.setVisible(true);
        return frame;

    }

    public JPanel AdminLogin(JFrame frame) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 250, 750, 500);
        panel.setBackground(Color.white);
        JLabel adminId = new JLabel("AdminId:");
        adminId.setBounds(250, 0, 80, 60);
        panel.add(adminId);
        JTextField idText = new JTextField(20);
        idText.setBounds(350, 10, 200, 40);
        panel.add(idText);

        JLabel emaillabel = new JLabel("Email:");
        emaillabel.setBounds(250, 90, 80, 60);
        panel.add(emaillabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(350, 100, 200, 40);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(250, 190, 80, 60);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(350, 200, 200, 40);
        panel.add(passwordText);

        JButton Loginbutton = new JButton("Login");
        Loginbutton.setBounds(230, 300, 100, 40);
        Loginbutton.setFocusable(false);
        panel.add(Loginbutton);

        Loginbutton.addActionListener(e -> {

            try {

                Admin admin = new Admin(emailField.getText(), passwordText.getText(),
                        Integer.parseInt(idText.getText()));
                Files file = new Files();
                admin.login(frame, file);
            } catch (Exception g) {
                JOptionPane.showMessageDialog(null, "Please Enter All details with normal form");
            }
        });

        JButton registrarbutton = new JButton("registrar");
        registrarbutton.setBounds(450, 300, 100, 40);
        registrarbutton.setFocusable(false);
        panel.add(registrarbutton);
        registrarbutton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setSize(300, 300);
            dialog.setLayout(null);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            JLabel label = new JLabel("AdminId");
            label.setBounds(110, 1, 80, 60);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            dialog.add(label);
            JTextField text = new JTextField(20);
            text.setBounds(50, 60, 200, 40);
            dialog.add(text);
            JButton con = new JButton("Continue");
            con.setBounds(100, 200, 100, 40);
            con.setFocusable(false);
            dialog.add(con);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    frame.setEnabled(false);
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    frame.setEnabled(true);

                }
            });
            con.addActionListener(g -> {
                try {
                    Admin admin = new Admin(Integer.parseInt(text.getText()));
                    Files file = new Files();
                    admin.confirmAdminId(file, dialog, frame);

                } catch (Exception fd) {
                    JOptionPane.showMessageDialog(null, "Invalid ID");
                }

            });

        });
        return panel;
    }

    public void Adminwork(Files file) {

        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        ImageIcon imageIcon = new ImageIcon("src/main/resources/2151252417.jpg");

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        };

        frame.add(panel);

        frame.setVisible(true);
        JFrame adminwork = new JFrame("Admin");
        adminwork.setLayout(null);
        adminwork.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminwork.setLocationRelativeTo(null);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        adminwork.setIconImage(imageIcons.getImage());
        adminwork.setResizable(false);
        adminwork.setVisible(true);

        adminwork.setBounds(400, 50, 500, 900);
        JMenuBar menuBar = new JMenuBar();
        adminwork.setJMenuBar(menuBar);
        JMenu logoutMenu = new JMenu("Log Out");
        logoutMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent v) {
                Admin admin = new Admin();
                admin.logout(adminwork, frame);
            }
        });

        logoutMenu.setEnabled(false);

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(logoutMenu);

        JButton addticketbutton = new JButton("Add Ticket");
        addticketbutton.setBounds(150, 50, 200, 40);
        addticketbutton.setFocusable(false);
        adminwork.add(addticketbutton);
        addticketbutton.addActionListener(l -> {
            AddTicket(file, adminwork);

        });

        JButton removeticketbutton = new JButton("Remove Ticket");
        removeticketbutton.setBounds(150, 190, 200, 40);
        removeticketbutton.setFocusable(false);
        adminwork.add(removeticketbutton);
        removeticketbutton.addActionListener(y -> {
            removeTicketFrame(file, adminwork);

        });

        JButton editticketbutton = new JButton("Edit Ticket");
        editticketbutton.setFocusable(false);
        editticketbutton.setBounds(150, 120, 200, 40);
        adminwork.add(editticketbutton);
        editticketbutton.addActionListener(y -> {
            editTicket(file, adminwork);
        });

        JButton addtrainbutton = new JButton("Add Trian");
        addtrainbutton.setBounds(150, 260, 200, 40);
        addtrainbutton.setFocusable(false);
        addtrainbutton.addActionListener(l -> {
            AddTrainFrame(adminwork, file);
        });
        adminwork.add(addtrainbutton);

        JButton removetrinbutton = new JButton("Remove Train");
        removetrinbutton.setBounds(150, 330, 200, 40);
        removeticketbutton.setFocusable(false);
        adminwork.add(removetrinbutton);
        removetrinbutton.addActionListener(l -> {
            removeTrainFrame(file, adminwork);

        });

        JButton edittrinbutton = new JButton("Edit Train");
        edittrinbutton.setBounds(150, 400, 200, 40);
        edittrinbutton.setFocusable(false);
        adminwork.add(edittrinbutton);
        edittrinbutton.addActionListener(l -> {
            editTrain(file, adminwork);

        });

        JButton removecustomerbButton = new JButton("Remove Customer");
        removecustomerbButton.setBounds(150, 470, 200, 40);
        removecustomerbButton.setFocusable(false);
        adminwork.add(removecustomerbButton);
        removecustomerbButton.addActionListener(x -> {
            removecustomer(adminwork, file);

        });
        JButton removeAdminButton = new JButton("Remove Admin");
        removeAdminButton.setBounds(150, 540, 200, 40);
        removeAdminButton.setFocusable(false);
        adminwork.add(removeAdminButton);

        removeAdminButton.addActionListener(x -> {
            removeAdmin(file, adminwork);

        });
        JButton viewTrain = new JButton("View Trains");
        viewTrain.setBounds(150, 610, 200, 40);
        viewTrain.setFocusable(false);
        adminwork.add(viewTrain);
        viewTrain.addActionListener(x -> {
            Admin admin = new Admin();
            admin.viewTrains(file);
        });
        JButton viewTicket = new JButton("View Tickets");
        viewTicket.setBounds(150, 680, 200, 40);
        viewTicket.setFocusable(false);
        adminwork.add(viewTicket);
        viewTicket.addActionListener(x -> {
            Admin admin = new Admin();
            admin.viewTickets(file);

        });
    }

    public void removecustomer(JFrame frame, Files file) {
        JDialog dialog = new JDialog();
        dialog.setSize(300, 300);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        dialog.setIconImage(imageIcons.getImage());
        dialog.setResizable(false);
        dialog.setVisible(true);

        JLabel label = new JLabel("Customer");
        label.setBounds(110, 1, 150, 60);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        dialog.add(label);
        JTextField text = new JTextField(20);
        text.setBounds(50, 60, 200, 40);
        dialog.add(text);
        JButton con = new JButton("Remove");
        con.setBounds(100, 200, 100, 40);
        dialog.add(con);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        con.addActionListener(g -> {
            try {
                Admin admin = new Admin();
                Customer customer = new Customer(text.getText(), null);
                admin.removeCustomer(file, dialog, customer);
            } catch (Exception e) {

            }

        });

    }

    public void removeAdmin(Files file, JFrame frame) {

        JDialog dialog = new JDialog();
        dialog.setSize(300, 300);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(null);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        dialog.setIconImage(imageIcons.getImage());
        dialog.setResizable(false);
        dialog.setVisible(true);

        JLabel label = new JLabel("AdminId");
        label.setBounds(110, 1, 80, 60);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        dialog.add(label);
        JTextField text = new JTextField(20);
        text.setBounds(50, 60, 200, 40);
        dialog.add(text);
        JButton con = new JButton("Remove");
        con.setBounds(100, 200, 100, 40);
        dialog.add(con);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        con.addActionListener(s -> {
            try {
                Admin admin = new Admin(null, null, Integer.parseInt(text.getText()));
                admin.removeAdmin(file, frame);
            } catch (Exception e) {

            }

        });

    }

    public JFrame AddTicket(Files file, JFrame frame) {
        HashMap<String, HashMap> trains = new HashMap<String, HashMap>();
        trains = file.loadTrains(trains);
        JFrame addTicketframe = new JFrame("Add Ticket");
        addTicketframe.setLayout(null);
        addTicketframe.setLocationRelativeTo(null);
        addTicketframe.setResizable(false);

        addTicketframe.setBounds(300, 50, 450, 600);
        JLabel ticketId = new JLabel("Ticket Id");
        ticketId.setBounds(20, 10, 200, 60);
        addTicketframe.add(ticketId);
        JTextField ticketIdtextfeld = new JTextField(20);
        ticketIdtextfeld.setBounds(210, 25, 200, 30);
        addTicketframe.add(ticketIdtextfeld);
        JLabel ticketTypLabel = new JLabel("Ticket Type");
        ticketTypLabel.setBounds(20, 45, 200, 60);
        addTicketframe.add(ticketTypLabel);
        JTextField ticketTypTextField = new JTextField(20);
        ticketTypTextField.setBounds(210, 60, 200, 30);
        addTicketframe.add(ticketTypTextField);
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(20, 85, 200, 60);
        addTicketframe.add(priceLabel);
        JTextField pricetextfeld = new JTextField(20);
        pricetextfeld.setBounds(210, 100, 200, 30);
        addTicketframe.add(pricetextfeld);
        JLabel trainLabel = new JLabel("Train");
        trainLabel.setBounds(20, 125, 200, 60);
        addTicketframe.add(trainLabel);
        JLabel seatLabel = new JLabel("Seat");
        seatLabel.setBounds(20, 165, 200, 60);
        addTicketframe.add(seatLabel);

        JComboBox<String> trainComboBox = new JComboBox<>();
        JComboBox<String> seatsoftrain = new JComboBox<>();
        for (String each : trains.keySet()) {
            HashMap<String, Object> trainsinfo = trains.get(each);
            trainComboBox.addItem((String) trainsinfo.get("TrainName"));

        }

        trainComboBox.addActionListener(e -> {
            HashMap<String, HashMap> selectseats = new HashMap<String, HashMap>();
            selectseats = file.loadTrains(selectseats);
            for (HashMap<String, Object> each : selectseats.values()) {
                if (each.get("TrainName").equals((String) trainComboBox.getSelectedItem())) {
                    ArrayList<String> seats = (ArrayList<String>) (each.get("Seats"));
                    seatsoftrain.removeAllItems();
                    for (String seat : seats) {
                        seatsoftrain.addItem(seat);
                    }
                }

            }

        });

        trainComboBox.setBounds(210, 140, 200, 30);
        addTicketframe.add(trainComboBox);
        seatsoftrain.setBounds(210, 180, 200, 30);
        JLabel tripnumLabel = new JLabel("Trip Number:");
        tripnumLabel.setBounds(20, 205, 80, 60);
        addTicketframe.add(tripnumLabel);

        JTextField tripnumextfeld = new JTextField(20);
        tripnumextfeld.setBounds(210, 220, 200, 30);
        addTicketframe.add(tripnumextfeld);

        JLabel tripfromLabel = new JLabel("from:");
        tripfromLabel.setBounds(20, 245, 80, 60);
        addTicketframe.add(tripfromLabel);

        JTextField ttripfromField = new JTextField(20);
        ttripfromField.setBounds(210, 260, 200, 30);
        addTicketframe.add(ttripfromField);

        JLabel triptoLabel = new JLabel("to:");
        triptoLabel.setBounds(20, 285, 80, 60);
        addTicketframe.add(triptoLabel);

        JTextField triptoField = new JTextField(20);
        triptoField.setBounds(210, 300, 200, 30);
        addTicketframe.add(triptoField);

        JLabel tripDateLabel = new JLabel("Date;");
        tripDateLabel.setBounds(20, 325, 200, 60);
        addTicketframe.add(tripDateLabel);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(210, 340, 200, 30);
        addTicketframe.add(dateChooser);

        JLabel departureTimeLabel = new JLabel("Departure Time:");
        departureTimeLabel.setBounds(20, 365, 120, 60);
        addTicketframe.add(departureTimeLabel);

        SpinnerDateModel departureSpinnerModel = new SpinnerDateModel(new Date(), null, null,
                Calendar.HOUR_OF_DAY);
        JSpinner departureTimeSpinner = new JSpinner(departureSpinnerModel);
        JSpinner.DateEditor departureTimeEditor = new JSpinner.DateEditor(departureTimeSpinner,
                "HH:mm");
        departureTimeSpinner.setEditor(departureTimeEditor);
        departureTimeSpinner.setBounds(210, 380, 200, 30);
        addTicketframe.add(departureTimeSpinner);

        JLabel arrivalTimeLabel = new JLabel("duration:");
        arrivalTimeLabel.setBounds(20, 405, 100, 60);
        addTicketframe.add(arrivalTimeLabel);

        JTextField arrivalTimeLabelTextField = new JTextField();

        arrivalTimeLabelTextField.setBounds(210, 420, 200, 30);
        addTicketframe.add(arrivalTimeLabelTextField);
        addTicketframe.add(seatsoftrain);
        JButton addTicketButton = new JButton("Add Ticket");
        addTicketButton.setBounds(175, 500, 100, 35);
        addTicketframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });

        addTicketButton.addActionListener(e -> {
            try {
                Admin admin = new Admin();
                Station station = new Station(ttripfromField.getText());
                Station station2 = new Station(triptoField.getText());
                Date date = (Date) dateChooser.getDate();
                Date departureDate = (Date) departureSpinnerModel.getValue();
                LocalTime departureTime = departureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                Trip trip = new Trip(Integer.parseInt(tripnumextfeld.getText()), station, station2, date, departureTime,
                        Integer.parseInt(arrivalTimeLabelTextField.getText()));
                Train train = new Train(0, 0, (String) trainComboBox.getSelectedItem(), null);
                Ticket ticket = new Ticket(Integer.parseInt(ticketIdtextfeld.getText()), ticketTypTextField.getText(),
                        train, (String) seatsoftrain.getSelectedItem(),
                        Integer.parseInt(pricetextfeld.getText()), trip);
                admin.addTicket(ticket, trip, file, addTicketframe, seatsoftrain);
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Please enter all Ticket fields");
            }

        });

        addTicketframe.add(addTicketButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        addTicketframe.setIconImage(imageIcons.getImage());
        addTicketframe.setVisible(true);
        return addTicketframe;
    }

    public void editTicket(Files file, JFrame frame) {

        JFrame removeticketFrame = new JFrame("edit Ticket");

        removeticketFrame.setBounds(100, 150, 250, 300);
        removeticketFrame.setLayout(null);
        removeticketFrame.setLocationRelativeTo(null);
        removeticketFrame.setResizable(false);

        JLabel deLabel = new JLabel("Ticket ID");
        deLabel.setBounds(75, 20, 150, 50);
        deLabel.setFont(new Font("Arial", Font.BOLD, 18));
        removeticketFrame.add(deLabel);
        JTextField delField = new JTextField();
        delField.setBounds(20, 65, 200, 30);
        JLabel TrainIdlLabel = new JLabel("Train Name");
        TrainIdlLabel.setBounds(80, 100, 150, 50);
        TrainIdlLabel.setFont(new Font("Arial", Font.BOLD, 18));
        removeticketFrame.add(TrainIdlLabel);
        JTextField TrainIdField = new JTextField();
        TrainIdField.setBounds(20, 150, 200, 30);
        removeticketFrame.add(TrainIdField);
        removeticketFrame.add(delField);
        JButton delButton = new JButton("remove");
        delButton.setBounds(55, 210, 125, 30);
        removeticketFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        delButton.addActionListener(e -> {
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
                    if (trainName.equals(TrainIdField.getText())) {
                        trainFound = true;
                        if (ticketsinfo.containsKey(delField.getText())) {
                            removeticketFrame.dispose();

                            HashMap<String, HashMap> trains = new HashMap<String, HashMap>();

                            trains = file.loadTrains(trains);

                            JFrame addTicketframe = new JFrame("Add Ticket");
                            addTicketframe.setLayout(null);
                            addTicketframe.setLocationRelativeTo(null);
                            ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
                            addTicketframe.setIconImage(imageIcons.getImage());
                            addTicketframe.setResizable(false);

                            addTicketframe.setBounds(300, 50, 450, 600);
                            JLabel ticketId = new JLabel("Ticket Id");
                            ticketId.setBounds(20, 10, 200, 60);
                            addTicketframe.add(ticketId);
                            JTextField ticketIdtextfeld = new JTextField(20);
                            ticketIdtextfeld.setBounds(210, 25, 200, 30);
                            addTicketframe.add(ticketIdtextfeld);
                            JLabel ticketTypLabel = new JLabel("Ticket Type");
                            ticketTypLabel.setBounds(20, 45, 200, 60);
                            addTicketframe.add(ticketTypLabel);
                            JTextField ticketTypTextField = new JTextField(20);
                            ticketTypTextField.setBounds(210, 60, 200, 30);
                            addTicketframe.add(ticketTypTextField);
                            JLabel priceLabel = new JLabel("Price");
                            priceLabel.setBounds(20, 85, 200, 60);
                            addTicketframe.add(priceLabel);
                            JTextField pricetextfeld = new JTextField(20);
                            pricetextfeld.setBounds(210, 100, 200, 30);
                            addTicketframe.add(pricetextfeld);
                            JLabel trainLabel = new JLabel("Train");
                            trainLabel.setBounds(20, 125, 200, 60);
                            addTicketframe.add(trainLabel);
                            JLabel seatLabel = new JLabel("Seat");
                            seatLabel.setBounds(20, 165, 200, 60);
                            addTicketframe.add(seatLabel);

                            JComboBox<String> trainComboBox = new JComboBox<>();
                            JComboBox<String> seatsoftrain = new JComboBox<>();
                            for (String each : trains.keySet()) {
                                HashMap<String, Object> trainsinfo = trains.get(each);
                                trainComboBox.addItem((String) trainsinfo.get("TrainName"));

                            }

                            trainComboBox.addActionListener(g -> {
                                HashMap<String, HashMap> selectseats = new HashMap<String, HashMap>();
                                selectseats = file.loadTrains(selectseats);
                                for (HashMap<String, Object> each : selectseats.values()) {
                                    if (each.get("TrainName").equals((String) trainComboBox.getSelectedItem())) {
                                        ArrayList<String> seats = (ArrayList<String>) (each.get("Seats"));
                                        seatsoftrain.removeAllItems();
                                        for (String seat : seats) {
                                            seatsoftrain.addItem(seat);
                                        }
                                    }

                                }

                            });

                            trainComboBox.setBounds(210, 140, 200, 30);
                            addTicketframe.add(trainComboBox);
                            seatsoftrain.setBounds(210, 180, 200, 30);
                            JLabel tripnumLabel = new JLabel("Trip Number:");
                            tripnumLabel.setBounds(20, 205, 80, 60);
                            addTicketframe.add(tripnumLabel);

                            JTextField tripnumextfeld = new JTextField(20);
                            tripnumextfeld.setBounds(210, 220, 200, 30);
                            addTicketframe.add(tripnumextfeld);

                            JLabel tripfromLabel = new JLabel("from:");
                            tripfromLabel.setBounds(20, 245, 80, 60);
                            addTicketframe.add(tripfromLabel);

                            JTextField ttripfromField = new JTextField(20);
                            ttripfromField.setBounds(210, 260, 200, 30);
                            addTicketframe.add(ttripfromField);

                            JLabel triptoLabel = new JLabel("to:");
                            triptoLabel.setBounds(20, 285, 80, 60);
                            addTicketframe.add(triptoLabel);

                            JTextField triptoField = new JTextField(20);
                            triptoField.setBounds(210, 300, 200, 30);
                            addTicketframe.add(triptoField);

                            JLabel tripDateLabel = new JLabel("Date;");
                            tripDateLabel.setBounds(20, 325, 200, 60);
                            addTicketframe.add(tripDateLabel);

                            JDateChooser dateChooser = new JDateChooser();
                            dateChooser.setBounds(210, 340, 200, 30);
                            addTicketframe.add(dateChooser);

                            JLabel departureTimeLabel = new JLabel("Departure Time:");
                            departureTimeLabel.setBounds(20, 365, 120, 60);
                            addTicketframe.add(departureTimeLabel);

                            SpinnerDateModel departureSpinnerModel = new SpinnerDateModel(new Date(), null, null,
                                    Calendar.HOUR_OF_DAY);
                            JSpinner departureTimeSpinner = new JSpinner(departureSpinnerModel);
                            JSpinner.DateEditor departureTimeEditor = new JSpinner.DateEditor(departureTimeSpinner,
                                    "HH:mm");
                            departureTimeSpinner.setEditor(departureTimeEditor);
                            departureTimeSpinner.setBounds(210, 380, 200, 30);
                            addTicketframe.add(departureTimeSpinner);

                            JLabel arrivalTimeLabel = new JLabel("duration:");
                            arrivalTimeLabel.setBounds(20, 405, 100, 60);
                            addTicketframe.add(arrivalTimeLabel);

                            JTextField arrivalTimeLabelTextField = new JTextField();

                            arrivalTimeLabelTextField.setBounds(210, 420, 200, 30);
                            addTicketframe.add(arrivalTimeLabelTextField);
                            addTicketframe.add(seatsoftrain);
                            JButton addTicketButton = new JButton("Add Ticket");
                            addTicketButton.setBounds(175, 500, 100, 35);
                            addTicketframe.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowOpened(WindowEvent e) {
                                    frame.setEnabled(false);
                                }

                                @Override
                                public void windowClosing(WindowEvent e) {
                                    frame.setEnabled(true);

                                }
                            });

                            addTicketButton.addActionListener(n -> {
                                try {
                                    Station station = new Station(ttripfromField.getText());
                                    Station station2 = new Station(triptoField.getText());
                                    Date date = (Date) dateChooser.getDate();
                                    Date departureDate = (Date) departureSpinnerModel.getValue();
                                    LocalTime departureTime = departureDate.toInstant().atZone(ZoneId.systemDefault())
                                            .toLocalTime();
                                    Trip trip = new Trip(Integer.parseInt(tripnumextfeld.getText()), station, station2,
                                            date, departureTime,
                                            Integer.parseInt(arrivalTimeLabelTextField.getText()));
                                    Train train = new Train(0, 0, (String) trainComboBox.getSelectedItem(), null);

                                    Ticket ticket = new Ticket(Integer.parseInt(delField.getText()),
                                            ticketTypTextField.getText(), train,
                                            (String) seatsoftrain.getSelectedItem(),
                                            Integer.parseInt(pricetextfeld.getText()), trip);
                                    Admin admin = new Admin();
                                    admin.editTicket(file, addTicketframe, ticket, trip, seatsoftrain);

                                } catch (Exception g) {
                                    JOptionPane.showMessageDialog(null, "Please enter Vaild Information");
                                }

                            });
                            addTicketframe.add(addTicketButton);

                            addTicketframe.setVisible(true);

                            try {
                                file.SaveTicket(tickets);
                            } catch (Exception e1) {
                            }
                            i++;
                        } else {
                            JOptionPane.showMessageDialog(removeticketFrame, "Invalid Ticket Id");
                            break;
                        }
                    }
                }
                if (!trainFound) {
                    JOptionPane.showMessageDialog(removeticketFrame, "Invalid Train Name");
                }
            } catch (Exception z) {
            }

        });
        removeticketFrame.add(delButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        removeticketFrame.setIconImage(imageIcons.getImage());
        removeticketFrame.setVisible(true);

    }

    public void editTrain(Files file, JFrame frame) {

        JFrame edittrainFrame = new JFrame("Edit trian");

        edittrainFrame.setBounds(100, 150, 250, 250);
        edittrainFrame.setLayout(null);
        edittrainFrame.setLocationRelativeTo(null);

        JLabel deLabel = new JLabel("Trian ID");
        deLabel.setBounds(75, 20, 150, 50);
        deLabel.setFont(new Font("Arial", Font.BOLD, 18));
        edittrainFrame.add(deLabel);
        JTextField delField = new JTextField();
        delField.setBounds(20, 65, 200, 30);
        edittrainFrame.add(delField);
        JButton delButton = new JButton("Edit");
        delButton.setBounds(55, 120, 125, 30);

        edittrainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        delButton.addActionListener(e -> {
            HashMap<String, HashMap> trains = new HashMap<String, HashMap>();
            trains = file.loadTrains(trains);
            if (trains.containsKey(delField.getText())) {
                edittrainFrame.dispose();
                JFrame addtrianFrame = new JFrame("ADD trian");
                addtrianFrame.setLayout(null);
                addtrianFrame.setLocationRelativeTo(null);

                addtrianFrame.setBounds(300, 50, 450, 600);
                JLabel triannameLabel = new JLabel("Entar trian Name:");
                triannameLabel.setBounds(20, 10, 200, 60);
                addtrianFrame.add(triannameLabel);

                JTextField triannametextfeld = new JTextField(20);
                triannametextfeld.setBounds(210, 25, 200, 30);
                addtrianFrame.add(triannametextfeld);

                JLabel seatLabel = new JLabel("Select seats number:");
                seatLabel.setBounds(15, 80, 200, 60);
                addtrianFrame.add(seatLabel);

                Integer[] seatsn = new Integer[5000];
                for (int i = 0; i < 5000; i++) {
                    seatsn[i] = i + 18;
                }
                JComboBox<Integer> seatNumbers = new JComboBox<>(seatsn);
                seatNumbers.setBounds(210, 95, 200, 30);
                addtrianFrame.add(seatNumbers);

                JButton addButton = new JButton("add Trian");
                addButton.setBounds(150, 450, 100, 35);
                addtrianFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        frame.setEnabled(false);
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        frame.setEnabled(true);

                    }
                });
                addButton.addActionListener(y -> {
                    try {
                        ArrayList<String> seatsno = new ArrayList<String>();
                        Train train = new Train((int) seatNumbers.getSelectedItem(),
                                Integer.parseInt(delField.getText()),
                                triannametextfeld.getText(), seatsno);
                        train.setSeats(seatsno);
                        Admin admin = new Admin();
                        admin.editTrain(file, frame, train);

                    } catch (Exception Z) {
                        JOptionPane.showMessageDialog(null, "Please enter all Ticket fields");
                    }

                });
                addtrianFrame.add(addButton);
                ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
                addtrianFrame.setIconImage(imageIcons.getImage());
                addtrianFrame.setResizable(false);
                addtrianFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(edittrainFrame, "Invalid Train Id");
            }

        });
        edittrainFrame.add(delButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        edittrainFrame.setIconImage(imageIcons.getImage());
        edittrainFrame.setVisible(true);

    }

    public static JFrame removeTicketFrame(Files file, JFrame frame) {
        JFrame removeticketFrame = new JFrame("remove Ticket");

        removeticketFrame.setBounds(100, 150, 250, 300);
        removeticketFrame.setLayout(null);
        removeticketFrame.setLocationRelativeTo(null);

        JLabel deLabel = new JLabel("Ticket ID");
        deLabel.setBounds(75, 20, 150, 50);
        deLabel.setFont(new Font("Arial", Font.BOLD, 18));
        removeticketFrame.add(deLabel);
        JTextField delField = new JTextField();
        delField.setBounds(20, 65, 200, 30);
        JLabel TrainIdlLabel = new JLabel("Train Name");
        TrainIdlLabel.setBounds(80, 100, 150, 50);
        TrainIdlLabel.setFont(new Font("Arial", Font.BOLD, 18));
        removeticketFrame.add(TrainIdlLabel);
        JTextField TrainIdField = new JTextField();
        TrainIdField.setBounds(20, 150, 200, 30);
        removeticketFrame.add(TrainIdField);
        removeticketFrame.add(delField);
        JButton delButton = new JButton("remove");
        delButton.setBounds(55, 210, 125, 30);

        removeticketFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        delButton.addActionListener(e -> {
            try {
                Train train = new Train(0, 0, TrainIdField.getText(), null);
                Ticket ticket = new Ticket(Integer.parseInt(delField.getText()), null, train, null,
                        0, null);

                Admin admin = new Admin();
                admin.removeTicket(file, frame, ticket);
            } catch (Exception g) {
                JOptionPane.showMessageDialog(null, "Please enter all Ticket fields");
            }
        });

        removeticketFrame.add(delButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        removeticketFrame.setIconImage(imageIcons.getImage());
        removeticketFrame.setVisible(true);
        return removeticketFrame;

    }

    public static JFrame removeTrainFrame(Files file, JFrame frame) {
        JFrame removeTrFrame = new JFrame("remove trian");

        removeTrFrame.setBounds(100, 150, 250, 250);
        removeTrFrame.setLayout(null);
        removeTrFrame.setLocationRelativeTo(null);

        JLabel deLabel = new JLabel("Trian ID");
        deLabel.setBounds(75, 20, 150, 50);
        deLabel.setFont(new Font("Arial", Font.BOLD, 18));
        removeTrFrame.add(deLabel);
        JTextField delField = new JTextField();
        delField.setBounds(20, 65, 200, 30);
        removeTrFrame.add(delField);
        JButton delButton = new JButton("remove");
        delButton.setBounds(55, 120, 125, 30);

        removeTrFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }

        });

        delButton.addActionListener(e -> {
            try {
                Admin admin = new Admin();
                Train train = new Train(0, Integer.parseInt(delField.getText()), null, null);
                admin.removeTrain(file, removeTrFrame, train);

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Please enter vaild trainID");
            }

        });
        removeTrFrame.add(delButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        removeTrFrame.setIconImage(imageIcons.getImage());
        removeTrFrame.setVisible(true);
        return removeTrFrame;
    }

    public static JFrame AddTrainFrame(JFrame frame, Files file) {
        JFrame addtrianFrame = new JFrame("ADD trian");
        addtrianFrame.setLayout(null);
        addtrianFrame.setLocationRelativeTo(null);

        addtrianFrame.setBounds(300, 50, 450, 600);
        JLabel triannameLabel = new JLabel("Entar trian Name:");
        triannameLabel.setBounds(20, 10, 200, 60);
        addtrianFrame.add(triannameLabel);

        JTextField triannametextfeld = new JTextField(20);
        triannametextfeld.setBounds(210, 25, 200, 30);
        addtrianFrame.add(triannametextfeld);

        JLabel trianidLabel = new JLabel("Entar trian ID:");
        trianidLabel.setBounds(20, 45, 80, 60);
        addtrianFrame.add(trianidLabel);

        JTextField trianidtextfeld = new JTextField();
        trianidtextfeld.setBounds(210, 60, 200, 30);
        addtrianFrame.add(trianidtextfeld);
        JLabel seatLabel = new JLabel("Select seats number:");
        seatLabel.setBounds(15, 80, 200, 60);
        addtrianFrame.add(seatLabel);
        Integer[] seatsn = new Integer[5000];
        for (int i = 0; i < 5000; i++) {
            seatsn[i] = i + 18;
        }
        JComboBox<Integer> seatNumbers = new JComboBox<>(seatsn);
        seatNumbers.setBounds(210, 95, 200, 30);
        addtrianFrame.add(seatNumbers);

        JButton addButton = new JButton("add Trian");
        addButton.setBounds(150, 450, 100, 35);
        addtrianFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.setEnabled(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);

            }
        });
        addButton.addActionListener(e -> {
            try {
                ArrayList<String> seatsno = new ArrayList<String>();
                Train train = new Train((int) seatNumbers.getSelectedItem(),
                        Integer.parseInt(trianidtextfeld.getText()),
                        triannametextfeld.getText(),
                        seatsno);
                train.setSeats(seatsno);

                Admin admin = new Admin();
                admin.addTrain(file, frame, train);
            } catch (Exception g) {
                JOptionPane.showMessageDialog(null, "Please enter vaild Train details");
            }

        });
        addtrianFrame.add(addButton);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        addtrianFrame.setIconImage(imageIcons.getImage());
        addtrianFrame.setVisible(true);
        return addtrianFrame;

    }

    public static JFrame Book() throws Exception {
        HashMap<String, HashMap> tickets = new HashMap<String, HashMap>();
        Files file = new Files();
        ArrayList<Train> trainlist = file.loadCategory();

        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setUndecorated(true);
        ImageIcon imageIcon = new ImageIcon("src/main/resources/2151017899.jpg");

        // Create a new JPanel with overridden paintComponent method
        JPanel panels = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the image on the panel
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        };

        // Add the JPanel to the JFrame
        frame1.add(panels);
        frame1.setVisible(true);

        tickets = file.LoadTicket(tickets);
        HashSet<String> uniqueFromValues = new HashSet<>();
        HashSet<String> uniqueToValues = new HashSet<>();
        JFrame frame = new JFrame("Book Ticket");
        JMenuBar menuBar = new JMenuBar();

        frame.setSize(1500, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setUndecorated(false);

        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 300, 1500);
        Color semiTransparentBorderColor = new Color(0, 0, 0, 30);
        panel.setBorder(BorderFactory.createLineBorder(semiTransparentBorderColor));

        panel.setOpaque(false);
        JPanel centerpanel = new JPanel();
        centerpanel.setLayout(null);
        centerpanel.setBounds(300, 0, 1200, 1500);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 10, 1200, 800);
        centerpanel.add(scrollPane);
        table.setBounds(0, 10, 1200, 800);
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // This causes all cells to be not editable
                return false;
            }
        };
        // Set column names
        tableModel.addColumn("Ticket ID");
        tableModel.addColumn("Ticket Type");
        tableModel.addColumn("Ticket Price");
        tableModel.addColumn("Ticket Seat");
        tableModel.addColumn("From");
        tableModel.addColumn("To");
        tableModel.addColumn("Date");
        tableModel.addColumn("Trip Number");
        tableModel.addColumn("Trip Depature Time");
        tableModel.addColumn("Trip Duration");

        // Set the model to the table
        table.setModel(tableModel);

        // Create labels
        JLabel dateLabel = new JLabel("Date:");
        JLabel fromLabel = new JLabel("From:");
        JLabel toLabel = new JLabel("To:");

        // Create text fields
        JDateChooser dateField = new JDateChooser();
        dateField.setBounds(210, 340, 200, 30);

        for (HashMap<String, HashMap> ticketCategory : tickets.values()) {
            for (HashMap<String, Object> ticket : ticketCategory.values()) {
                // Get the "From" and "To" field values

                // Add the "name" field value to the HashSet
                uniqueFromValues.add((String) ticket.get("From"));
                uniqueToValues.add((String) ticket.get("To"));
            }
        }

        // Create JComboBoxes for "From" and "To" fields
        JComboBox<String> fromComboBox = new JComboBox<>();
        JComboBox<String> toComboBox = new JComboBox<>();

        // Iterate over the HashSet and add each unique "From" field value to the
        // JComboBox
        for (String fromValue : uniqueFromValues) {
            fromComboBox.addItem(fromValue);
        }

        // Iterate over the HashSet and add each unique "To" field value to the
        // JComboBox
        for (String toValue : uniqueToValues) {
            toComboBox.addItem(toValue);
        }

        // Add JComboBoxes to the panel

        // Create button
        JButton bookButton = new JButton("Search");
        bookButton.addActionListener(e -> {
            Customer customer = new Customer();
            customer.search(table, file, tableModel, dateField, fromComboBox, toComboBox);

        });

        JButton BookButton = new JButton("Book");
        BookButton.setBounds(0, 820, 1200, 200);
        centerpanel.add(BookButton);
        BookButton.addActionListener(e -> {
            Customer customer = new Customer();
            customer.Book(table, file, tableModel);
        });
        // Add components to frame
        dateLabel.setBounds(100, 500, 80, 25);
        dateField.setBounds(40, 530, 165, 25);
        fromLabel.setBounds(100, 400, 80, 25);
        fromComboBox.setBounds(40, 430, 165, 25);
        toLabel.setBounds(100, 300, 80, 25);
        toComboBox.setBounds(40, 330, 165, 25);
        bookButton.setBounds(80, 600, 80, 25);
        JMenu categoryMenu = new JMenu("Trains");
        for (Train elem : trainlist) {

            JMenuItem menuItem = new JMenuItem(elem.getName());
            categoryMenu.add(menuItem);

            menuItem.addActionListener(e -> {
                Customer customer = new Customer();
                customer.selectitem(tableModel, file, elem.getName().toString());

            });

        }

        // Add the category menu to the menu bar
        menuBar.add(categoryMenu);
        JMenu logoutMenu = new JMenu("Log Out");
        logoutMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent v) {
                Customer customer = new Customer();
                customer.logout(frame, frame1);
            }
        });

        // Remove the ability to click the menu to expand it
        logoutMenu.setEnabled(false);

        // Add the menu to the menu bar
        menuBar.add(Box.createHorizontalGlue()); // This line is to push the logoutMenu to the right
        menuBar.add(logoutMenu);

        // Add components to frame
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(fromLabel);

        panel.add(toLabel);
        panel.add(fromComboBox);

        panel.add(toComboBox);

        panel.add(bookButton);
        frame.add(panel);
        frame.add(centerpanel);
        // Pack the frame to fit around the components
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setResizable(false);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(imageIcons.getImage());
        frame.setVisible(true);

        return frame;
    }

    public JFrame viewTrains(Files file) {
        HashMap<String, HashMap> trains = new HashMap<String, HashMap>();

        trains = file.loadTrains(trains);

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setResizable(false);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 500, 500);
        frame.add(scrollPane);

        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // This causes all cells to be not editable
                return false;
            }
        };

        // Set column names
        tableModel.addColumn("Train ID");
        tableModel.addColumn("Train Name");
        tableModel.addColumn("Capacity");

        // Iterate over the HashMap and add each entry to the table model
        for (Entry<String, HashMap> entry : trains.entrySet()) {
            String trainId = entry.getKey();
            HashMap<String, Object> trainData = entry.getValue();
            String trainName = (String) trainData.get("TrainName");
            int capacity = (int) trainData.get("Capacity");
            ArrayList<String> seats = (ArrayList<String>) trainData.get("Seats");

            // Add a row to the table model
            tableModel.addRow(new Object[] { trainId, trainName, capacity });
        }

        // Set the model to the table
        table.setModel(tableModel);

        frame.setVisible(true);
        return frame;

    }

    public JFrame viewTickets(Files file) {

        HashMap<String, HashMap<String, HashMap<String, Object>>> tickets = new HashMap<>();
        try {
            tickets = file.LoadTicket(tickets);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 500);
        frame.setResizable(false);
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 500);
        frame.add(scrollPane);
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.addColumn("Ticket ID");
        tableModel.addColumn("Seat");
        tableModel.addColumn("Price");
        tableModel.addColumn("Duration");
        tableModel.addColumn("From");
        tableModel.addColumn("To");
        tableModel.addColumn("Departure Time");
        tableModel.addColumn("Trip Number");
        tableModel.addColumn("Date");
        tableModel.addColumn("Ticket Type");

        for (Map.Entry<String, HashMap<String, HashMap<String, Object>>> outerEntry : tickets.entrySet()) {

            HashMap<String, HashMap<String, Object>> innerMap = outerEntry.getValue();
            for (Map.Entry<String, HashMap<String, Object>> innerEntry : innerMap.entrySet()) {
                String ticketId = innerEntry.getKey();
                HashMap<String, Object> detailsMap = innerEntry.getValue();
                tableModel.addRow(new Object[] {
                        ticketId,
                        detailsMap.get("Seat"),
                        detailsMap.get("Price"),
                        detailsMap.get("Duration"),
                        detailsMap.get("From"),
                        detailsMap.get("To"),
                        detailsMap.get("Departure Time"),
                        detailsMap.get("Trip Number"),
                        detailsMap.get("Date"),
                        detailsMap.get("Ticket Type")
                });
            }
        }

        table.setModel(tableModel);
        frame.setVisible(true);

        return frame;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.setBounds(0, 0, 750, 250);
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton adminradio = new JRadioButton("Admin");
        JRadioButton cusradio = new JRadioButton("Customer");
        buttonGroup.add(adminradio);
        buttonGroup.add(cusradio);
        adminradio.setSelected(true);
        adminradio.setBounds(200, 30, 100, 50);
        adminradio.setBackground(Color.white);
        cusradio.setBounds(450, 30, 100, 50);
        cusradio.setBackground(Color.white);

        panel.add(adminradio);
        panel.add(cusradio);
        frame.add(panel);
        Main main = new Main();
        JPanel adminpan = main.AdminLogin(frame);

        JPanel coupan = main.CustomerLogin(frame);

        cusradio.addActionListener(e -> {
            frame.add(coupan);
            frame.getContentPane().remove(adminpan);
            frame.validate();
            frame.repaint();
        });
        adminradio.addActionListener(e -> {
            frame.add(adminpan);
            frame.getContentPane().remove(coupan);
            frame.validate();
            frame.repaint();
        });
        adminradio.doClick();

        frame.setLayout(null);
        frame.setTitle("RailWay Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(750, 750);
        ImageIcon imageIcons = new ImageIcon("src/main/resources/logo.png");
        frame.setIconImage(imageIcons.getImage());
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
