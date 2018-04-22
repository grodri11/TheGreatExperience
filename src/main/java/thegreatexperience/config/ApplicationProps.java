package thegreatexperience.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ApplicationProps {


<<<<<<< HEAD
    private String stockUrl = "https://www.alphavantage.co/query?";
    private String stockApiKey = "7DVAXDS48KAJVN2K";

    private String weatherUrl = "http://samples.openweathermap.org/data/2.5/weather?";
    private String weatherApiKey = "2f404fb69230b4614696b01efc6ce28c";

=======
    private String stockApiKey = "7DVAXDS48KAJVN2K";

>>>>>>> b798a2a... no message

    public String getStockApiKey() {
        return stockApiKey;
    }

    public void setStockApiKey(String stockApiKey) {
        this.stockApiKey = stockApiKey;
    }
<<<<<<< HEAD

    public String getWeatherApiKey() {
        return weatherApiKey;
    }

    public void setWeatherApiKey(String weatherApiKey) {
        this.weatherApiKey = weatherApiKey;
    }

    public String getStockUrl() {
        return stockUrl;
    }

    public void setStockUrl(String stockUrl) {
        this.stockUrl = stockUrl;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }
=======
>>>>>>> b798a2a... no message
}
