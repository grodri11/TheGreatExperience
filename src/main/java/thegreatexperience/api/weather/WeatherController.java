package thegreatexperience.api.weather;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thegreatexperience.api.RestClient;
import thegreatexperience.api.user.UserController;
import thegreatexperience.config.ApplicationProps;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final Logger log = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    ApplicationProps props;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/{city}")
    public ResponseEntity getStocks(@PathVariable String city){
        RestClient restClient = new RestClient(props.getWeatherUrl() + "q="+city+"&appid=" + props.getWeatherApiKey());

        JsonNode json = null;
        try{
            json = objectMapper.readTree(restClient.doGet());
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return ResponseEntity.ok(json);
    }


}
