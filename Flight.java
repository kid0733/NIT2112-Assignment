import java.time.LocalTime;

public class Flight {
    //initialize 7 variables:

    private String airline_name;
    private String flight_number;
    private String flight_origin;
    private String destination_city;
    private float airfare;
    private LocalTime departure_time;
    private LocalTime arrival_time;
    private float distance;
    private String aircraftType;
    private String pilotName;
    private int maxPassengers;

    //Constructor
    public Flight(String airline_name,String flight_number,String flight_origin,String destination_city,float airfare,LocalTime departure_time,LocalTime arrival_time, float distance){
        this.airline_name=airline_name;
        this.flight_number=flight_number;
        this.flight_origin=flight_origin;
        this.destination_city=destination_city;
        this.airfare=airfare;
        this.departure_time=departure_time;
        this.arrival_time=arrival_time;
        this.distance=distance;
        this.aircraftType = aircraftType;
        this.pilotName = pilotName;
        this.maxPassengers = maxPassengers;
    }


    // Getter methods
    public String getDestinationCity() {
        return destination_city;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getPilotName() {
        return pilotName;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public float getAirfare() {
        return airfare;
    }

    public LocalTime getDepartureTime() {
        return departure_time;
    }

    public LocalTime getArrivalTime() {
        return arrival_time;
    }

    public float getDistance() {
        return distance;
    }

    public String getAirlineName() {
        return airline_name;
    }

    public String getFlightNumber() {
        return flight_number;
    }

    public String getFlightOrigin() {
        return flight_origin;
    }



    // Setter methods
    public void setDestinationCity(String destination_city) {
        this.destination_city = destination_city;
    }

    public void setAirfare(float airfare) {
        this.airfare = airfare;
    }

    public void setDepartureTime(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrivalTime(LocalTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setAirlineName(String airline_name) {
        this.airline_name = airline_name;
    }

    public void setFlightNumber(String flight_number) {
        this.flight_number = flight_number;
    }

    public void setFlightOrigin(String flight_origin) {
        this.flight_origin = flight_origin;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    //toString Method
    public String toString(){
        return "\nFlight Details:\n" +
                "Airline Name: " + airline_name + "\n" +
                "Flight Number: " + flight_number + "\n" +
                "Flight Origin: " + flight_origin + "\n" +
                "Destination City: " + destination_city + "\n" +
                "Airfare: $" + airfare + "\n" +
                "Departure Time: " + departure_time + "\n" +
                "Arrival Time: " + arrival_time + "\n" +
                "Distance: " + distance + " miles\n" +
                "Aircraft Type: " + aircraftType + "\n" +
                "Pilot Name: " + pilotName + "\n" +
                "Max Passengers: " + maxPassengers +
                "\n\n";
    }
}