import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class FlightDetails {
    private ArrayList<Flight> flights;

    public FlightDetails() {
        flights = new ArrayList<>();
    }

    public boolean hasFlights() {
        return !flights.isEmpty();
    }

    public static void main(String[] args) {
        FlightDetails flightDetails = new FlightDetails();
        flightDetails.inputFlightDetails();
    }

    public void inputFlightDetails() {
        //Initialize Scanner
        Scanner scanner = new Scanner(System.in);

//--------------------CLI SECTION-------------------------------//
        // Getting the number of Flights:
        System.out.println("Enter the number of flights: ");
        int numFlights = scanner.nextInt();
        scanner.nextLine();

        // Input loop for x amount of flights
        for (int i = 0; i < numFlights; i++) {
            System.out.println("Enter the details of the Flight " + (i + 1) + ":");

            String airlineName;
            do {
                System.out.println("Airline Name: ");
                airlineName = scanner.nextLine();
                if (airlineName.isEmpty()) {
                    System.out.println("Airline Name cannot be empty. Please enter a valid Airline Name.");
                }
            } while (airlineName.isEmpty());

            String flightNumber;
            do {
                System.out.println("Flight Number: ");
                flightNumber = scanner.nextLine();
                if (flightNumber.isEmpty()) {
                    System.out.println("Flight Number cannot be empty. Please enter a valid Flight Number.");
                }
            } while (flightNumber.isEmpty());

            String flightOrigin;
            do {
                System.out.println("Flight Origin: ");
                flightOrigin = scanner.nextLine();
                if (flightOrigin.isEmpty()) {
                    System.out.println("Flight Origin cannot be empty. Please enter a valid Flight Origin.");
                }
            } while (flightOrigin.isEmpty());

            String destinationCity;
            do {
                System.out.println("Destination City: ");
                destinationCity = scanner.nextLine();
                if (destinationCity.isEmpty()) {
                    System.out.println("Destination City cannot be empty. Please enter a valid Destination City.");
                }
            } while (destinationCity.isEmpty());

            float airfare;
            do {
                System.out.println("Airfare: ");
                String airfareString = scanner.nextLine();
                try {
                    airfare = Float.parseFloat(airfareString);
                    if (airfare <= 0) {
                        System.out.println("Airfare must be a positive number. Please enter a valid Airfare.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Airfare format. Please enter a valid Airfare.");
                    airfare = -1; // Set airfare to an invalid value to trigger the loop
                }
            } while (airfare <= 0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");

            LocalTime departureTime;
            do {
                System.out.println("Departure Time (HH:mm:ss): ");
                String departureTimeString = scanner.nextLine();
                try {
                    departureTime = LocalTime.parse(departureTimeString, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid Departure Time format. Please enter a valid Departure Time (HH:mm:ss).");
                    departureTime = null; // Set departureTime to null to trigger the loop
                }
            } while (departureTime == null);

            LocalTime arrivalTime;
            do {
                System.out.println("Arrival Time (HH:mm:ss): ");
                String arrivalTimeString = scanner.nextLine();
                try {
                    arrivalTime = LocalTime.parse(arrivalTimeString, formatter);
                    if (arrivalTime.isBefore(departureTime)) {
                        System.out.println("Arrival Time must be after Departure Time. Please enter a valid Arrival Time.");
                        arrivalTime = null; // Set arrivalTime to null to trigger the loop
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid Arrival Time format. Please enter a valid Arrival Time (HH:mm:ss).");
                    arrivalTime = null; // Set arrivalTime to null to trigger the loop
                }
            } while (arrivalTime == null);

            float distance;
            do {
                System.out.println("Distance: ");
                String distanceString = scanner.nextLine();
                try {
                    distance = Float.parseFloat(distanceString);
                    if (distance <= 0) {
                        System.out.println("Distance must be a positive number. Please enter a valid Distance.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Distance format. Please enter a valid Distance.");
                    distance = -1; // Set distance to an invalid value to trigger the loop
                }
            } while (distance <= 0);

            // Creating a new Flight object and setting its attributes using setter methods
            Flight flight = new Flight("", "", "", "", 0.0f, null, null, 0.0f);
            flight.setAirlineName(airlineName);
            flight.setFlightNumber(flightNumber);
            flight.setFlightOrigin(flightOrigin);
            flight.setDestinationCity(destinationCity);
            flight.setAirfare(airfare);
            flight.setDepartureTime(departureTime);
            flight.setArrivalTime(arrivalTime);
            flight.setDistance(distance);

            // Adding the Flight object to the ArrayList
            flights.add(flight);
        }

        //Displaying pre-sorted flight details:
        System.out.println("Pre-sorted Flight Details:");
        for (Flight flight : flights) {
            System.out.println(flight);
            System.out.println();
            System.out.println();
        }

        //Sort Flight based off flight number (ascending number)
        flights.sort(Comparator.comparing(Flight::getFlightNumber));

        //Display sorted flight details
        System.out.println("Sorted Flight Details [ascending]: ");
        for (Flight flight : flights) {
            System.out.println();
            System.out.println(flight);
            System.out.println();
        }
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}