package api.stocks;

import api.RestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StocksController {


    @RequestMapping("/{stock}")
    public ResponseEntity<String> getStockInfo(){
        RestClient restClient = new RestClient("https://www.alphavantage.co/query?function=SECTOR&apikey=7DVAXDS48KAJVN2K");

        return restClient.doGet();
    }

    public static void main(String args[]){
        RestClient restClient = new RestClient("https://www.alphavantage.co/query?function=SECTOR&apikey=7DVAXDS48KAJVN2K");
        System.out.println(restClient.doGet());
    }
}
