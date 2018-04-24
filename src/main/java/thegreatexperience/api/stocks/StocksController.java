package thegreatexperience.api.stocks;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thegreatexperience.api.RestClient;
import thegreatexperience.api.weather.WeatherController;
import thegreatexperience.config.ApplicationProps;

@RestController
@RequestMapping("/stocks")
public class StocksController {
    private final Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    ApplicationProps props;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("")
    public ResponseEntity getStocks(){
        RestClient restClient = new RestClient(props.getStockUrl() + "function=SECTOR&outputsize=compact&apikey=" + props.getStockApiKey());

        JsonNode json = null;
        try{
             json = objectMapper.readTree(restClient.doGet());
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

        return ResponseEntity.ok(json);
    }

    @RequestMapping("{stock}")
    public ResponseEntity getStockInfo(@PathVariable String stock){
        RestClient restClient = new RestClient(props.getStockUrl() + "function=TIME_SERIES_WEEKLY&outputsize=compact&symbol="+stock+"&apikey=" + props.getStockApiKey());
        JsonNode json = null;

        try{
            json = objectMapper.readTree(restClient.doGet()).get("Weekly Time Series");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

        return ResponseEntity.ok(json);
    }

}