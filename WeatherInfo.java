public class WeatherInfo {
    private String description;
    private String generalCondition;
    private double temperature;

    public WeatherInfo(String description, String generalCondition, double temperature) {
        this.description = description;
        this.generalCondition = generalCondition;
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public String getGeneralCondition() {
        return generalCondition;
    }

    public double getTemperature() {
        return temperature;
    }
}
