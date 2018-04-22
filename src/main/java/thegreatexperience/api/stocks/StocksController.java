package thegreatexperience.api.stocks;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thegreatexperience.api.RestClient;
import thegreatexperience.config.ApplicationProps;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    @Autowired
    ApplicationProps props;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("")
    public String getStocks(){
        RestClient restClient = new RestClient(props.getStockUrl() + "function=SECTOR&outputsize=compact&apikey=" + props.getStockApiKey());

        JsonNode json = null;
        try{
            // json = objectMapper.readTree(restClient.doGet().getBody().toString());
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        return json.get("Weekly Time Series").toString();
    }

    @RequestMapping("{stock}")
    public ResponseEntity getStockInfo(@PathVariable String stock){
        RestClient restClient = new RestClient(props.getStockUrl() + "function=TIME_SERIES_WEEKLY&outputsize=compact&symbol="+stock+"&apikey=" + props.getStockApiKey());
        JsonNode json = null;

        try{
            json = objectMapper.readTree(restClient.doGet()).get("Weekly Time Series");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

        return ResponseEntity.ok(json);
    }

}