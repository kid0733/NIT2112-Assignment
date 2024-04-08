import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    public WeatherInfo getWeatherInfo(String city, String apiKey) {
        WeatherInfo weatherInfo = null;

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsing JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray weatherArray = jsonResponse.getJSONArray("weather");
            JSONObject weatherObject = weatherArray.getJSONObject(0);
            String weatherDescription = weatherObject.getString("description");

            // Map detailed descriptions to general conditions
            String generalWeatherCondition = mapToGeneralCondition(weatherDescription);

            JSONObject mainObject = jsonResponse.getJSONObject("main");
            double tempKelvin = mainObject.getDouble("temp");
            double tempCelsius = tempKelvin - 273.15;

            // Store weather information in WeatherInfo object
            weatherInfo = new WeatherInfo(weatherDescription, generalWeatherCondition, tempCelsius);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherInfo;
    }

    private String mapToGeneralCondition(String description) {
        String[] clearKeywords = {"clear"};
        String[] cloudyKeywords = {"cloud", "overcast", "mist"};
        String[] rainyKeywords = {"rain", "drizzle", "thunderstorm", "snow"};

        description = description.toLowerCase();

        for (String keyword : clearKeywords) {
            if (description.contains(keyword)) {
                return "clear";
            }
        }

        for (String keyword : cloudyKeywords) {
            if (description.contains(keyword)) {
                return "cloudy";
            }
        }

        for (String keyword : rainyKeywords) {
            if (description.contains(keyword)) {
                return "rainy";
            }
        }

        return "unknown";
    }
}
