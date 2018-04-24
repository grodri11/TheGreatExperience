package thegreatexperience.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class RestClient<T> {

    private String endpoint;


    public RestClient(String endpoint) {
        this.endpoint = endpoint;
    }

    private RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());

        return restTemplate;
    }

    public String doGet(){
        RestTemplate restTemplate = getRestTemplate();

        String response = restTemplate.getForObject(this.endpoint, String.class);

        return response;
    }

    private HttpHeaders getHeaders(List<HeaderBuilder> headerBuilderList){
        HttpHeaders httpHeaders = new HttpHeaders();

        for(HeaderBuilder header : headerBuilderList){
            httpHeaders.add(header.getHeaderName(), header.getHeaderValue());
        }

        return httpHeaders;
    }
}
