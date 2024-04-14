import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Form1 extends JFrame implements ActionListener {
    private JTextArea textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JTextArea textField8, textField9, textField10;
    private JButton displayButton;
    private FlightDetails flightDetails;

    public static void main(String[] args) {
        String apiKey = "ae9951144cd40aaaebd15d7c38eb0084"; // Replace "YOUR_API_KEY" with your actual API key
        String city = "Sydney"; // Replace "YOUR_CITY_NAME" with your city name

        WeatherApp weatherApp = new WeatherApp();
        WeatherInfo weatherInfo = weatherApp.getWeatherInfo(city, apiKey);

        // Store each value in its own variable
        String description = weatherInfo.getDescription();
        String generalCondition = weatherInfo.getGeneralCondition();
        double temperature = weatherInfo.getTemperature();

        // Format temperature to display limited decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedTemperature = df.format(temperature);

        // Display the weather information
        System.out.println("Description: " + description);
        System.out.println("General Condition: " + generalCondition);
        System.out.println("Temperature: " + formattedTemperature + "°C");

        FlightDetails flightDetails = new FlightDetails();
        flightDetails.inputFlightDetails();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new Form1(description, generalCondition, formattedTemperature, flightDetails);
            }
        });
    }

    public Form1(String description, String generalCondition, String formattedTemperature, FlightDetails flightDetails) {
        this.flightDetails = flightDetails;

        // Initialize GUI
        setTitle("Airline Manager");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(new Color(195, 195, 195), 5);

        // Setting window icon
        ImageIcon imageIcon = new ImageIcon("Flight.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(1000, 850, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        setIconImage(imageIcon.getImage());
        setLayout(null);

        // Flight Details Label:
        JLabel flightDetailsText = new JLabel();
        flightDetailsText.setText("Flight Details:");
        add(flightDetailsText);
        flightDetailsText.setHorizontalAlignment(JLabel.CENTER);
        flightDetailsText.setForeground(new Color(253, 255, 255));
        flightDetailsText.setFont(new Font("Levi Windows", Font.BOLD, 28));
        flightDetailsText.setBackground(new Color(125, 125, 125));
        flightDetailsText.setOpaque(true);
        flightDetailsText.setBorder(border);
        flightDetailsText.setVerticalAlignment(JLabel.TOP);
        flightDetailsText.setBounds(720, 10, 250, 100);

        // Text Areas and Labels:
        JLabel label1 = new JLabel("Airline Name:");
        label1.setBounds(730, 135, 100, 25);
        add(label1);
        textField1 = new JTextArea();
        textField1.setBounds(830, 135, 130, 75);
        textField1.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(textField1);
        scrollPane1.setBounds(830, 135, 130, 75);
        add(scrollPane1);

        JLabel label2 = new JLabel("Flight Number");
        label2.setBounds(730, 220, 100, 25);
        add(label2);
        textField2 = new JTextArea();
        textField2.setBounds(830, 220, 130, 75);
        textField2.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(textField2);
        scrollPane2.setBounds(830, 220, 130, 75);
        add(scrollPane2);

        JLabel label3 = new JLabel("Origin->Destination:");
        label3.setBounds(700, 305, 130, 50);
        add(label3);
        textField3 = new JTextArea();
        textField3.setBounds(730, 305, 130, 75);
        textField3.setEditable(false);
        JScrollPane scrollPane3 = new JScrollPane(textField3);
        scrollPane3.setBounds(830, 305, 130, 75);
        add(scrollPane3);

        JLabel label4 = new JLabel("Airfare");
        label4.setBounds(730, 390, 100, 25);
        add(label4);
        textField4 = new JTextArea();
        textField4.setBounds(830, 390, 130, 75);
        textField4.setEditable(false);
        JScrollPane scrollPane4 = new JScrollPane(textField4);
        scrollPane4.setBounds(830, 390, 130, 75);
        add(scrollPane4);

        JLabel label5 = new JLabel("Departure Time");
        label5.setBounds(730, 475, 100, 25);
        add(label5);
        textField5 = new JTextArea();
        textField5.setBounds(830, 475, 130, 75);
        textField5.setEditable(false);
        JScrollPane scrollPane5 = new JScrollPane(textField5);
        scrollPane5.setBounds(830, 475, 130, 75);
        add(scrollPane5);

        JLabel label6 = new JLabel("Arrival Time");
        label6.setBounds(730, 560, 100, 25);
        add(label6);
        textField6 = new JTextArea();
        textField6.setBounds(830, 560, 130, 75);
        textField6.setEditable(false);
        JScrollPane scrollPane6 = new JScrollPane(textField6);
        scrollPane6.setBounds(830, 560, 130, 75);
        add(scrollPane6);

        JLabel label7 = new JLabel("Distance");
        label7.setBounds(730, 645, 100, 25);
        add(label7);
        textField7 = new JTextArea();
        textField7.setBounds(830, 645, 130, 75);
        textField7.setEditable(false);
        JScrollPane scrollPane7 = new JScrollPane(textField7);
        scrollPane7.setBounds(830, 645, 130, 75);
        add(scrollPane7);

        JLabel label8 = new JLabel("Aircraft Type");
        label8.setBounds(50, 305, 100, 25);
        add(label8);
        textField8 = new JTextArea();
        textField8.setBounds(150, 305, 130, 75);
        textField8.setEditable(false);
        JScrollPane scrollPane8 = new JScrollPane(textField8);
        scrollPane8.setBounds(150, 305, 130, 75);
        add(scrollPane8);

        JLabel label9 = new JLabel("Pilot Name");
        label9.setBounds(50, 390, 100, 25);
        add(label9);
        textField9 = new JTextArea();
        textField9.setBounds(150, 390, 130, 75);
        textField9.setEditable(false);
        JScrollPane scrollPane9 = new JScrollPane(textField9);
        scrollPane9.setBounds(150, 390, 130, 75);
        add(scrollPane9);

        JLabel label10 = new JLabel("Max Passengers");
        label10.setBounds(50, 475, 100, 25);
        add(label10);
        textField10 = new JTextArea();
        textField10.setBounds(150, 475, 130, 75);
        textField10.setEditable(false);
        JScrollPane scrollPane10 = new JScrollPane(textField10);
        scrollPane10.setBounds(150, 475, 130, 75);
        add(scrollPane10);

        // Load the icons
        Icon sunnyIcon = new ImageIcon("sunny.png");
        Icon cloudyIcon = new ImageIcon("cloudy.png");
        Icon rainyIcon = new ImageIcon("rainy.png");

        //Weather Sections
        JLabel descriptionLabel = new JLabel("Description: " + description);
        descriptionLabel.setBounds(200, 125, 300, 25);
        descriptionLabel.setFont(new Font("Levi Windows", Font.BOLD, 20));
        descriptionLabel.setForeground(new Color(245, 245, 245));
        add(descriptionLabel);

        JLabel generalConditionLabel = new JLabel();
        generalConditionLabel.setBounds(60, 85, 150, 150);
        add(generalConditionLabel);

        // Determine which icon to use based on the general condition
        Icon iconToShow;
        switch (generalCondition.toLowerCase()) {
            case "clear":
                iconToShow = sunnyIcon;
                break;
            case "cloudy":
                iconToShow = cloudyIcon;
                break;
            case "rainy":
                iconToShow = rainyIcon;
                break;
            default:
                // Use a default icon if condition is not clear, cloudy, or rainy
                iconToShow = null;
                break;
        }

        // Set the icon on the label
        generalConditionLabel.setIcon(iconToShow);

        JLabel temperatureLabel = new JLabel("Temperature: " + formattedTemperature + "°C");
        temperatureLabel.setBounds(200, 175, 300, 25);
        temperatureLabel.setFont(new Font("Levi Windows", Font.BOLD, 20));
        temperatureLabel.setForeground(new Color(245, 245, 245));
        add(temperatureLabel);

        // Display Flights Button:
        displayButton = new JButton("Display Flights");
        displayButton.setBounds(270, 715, 150, 30);
        displayButton.addActionListener(this);
        add(displayButton);

        // Setting Background:
        getContentPane().setBackground(new Color(0, 128, 128));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayButton) {
            if (flightDetails.hasFlights()) {
                ArrayList<Flight> flights = flightDetails.getFlights();
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = new StringBuilder();
                StringBuilder sb5 = new StringBuilder();
                StringBuilder sb6 = new StringBuilder();
                StringBuilder sb7 = new StringBuilder();
                StringBuilder sb8 = new StringBuilder();
                StringBuilder sb9 = new StringBuilder();
                StringBuilder sb10 = new StringBuilder();

                for (Flight flight : flights) {
                    sb1.append(flight.getAirlineName()).append("\n");
                    sb2.append(flight.getFlightNumber()).append("\n");
                    sb3.append(flight.getFlightOrigin()).append(" to ").append(flight.getDestinationCity()).append("\n");
                    sb4.append(flight.getAirfare()).append("\n");
                    sb5.append(flight.getDepartureTime()).append("\n");
                    sb6.append(flight.getArrivalTime()).append("\n");
                    sb7.append(flight.getDistance()).append("\n");
                    sb8.append(flight.getAircraftType()).append("\n");
                    sb9.append(flight.getPilotName()).append("\n");
                    sb10.append(flight.getMaxPassengers()).append("\n");
                }

                textField1.setText(sb1.toString());
                textField2.setText(sb2.toString());
                textField3.setText(sb3.toString());
                textField4.setText(sb4.toString());
                textField5.setText(sb5.toString());
                textField6.setText(sb6.toString());
                textField7.setText(sb7.toString());
                textField8.setText(sb8.toString());
                textField9.setText(sb9.toString());
                textField10.setText(sb10.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No flights available.");
            }
        }
    }
}