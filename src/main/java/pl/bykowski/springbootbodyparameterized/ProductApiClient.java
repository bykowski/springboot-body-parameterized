package pl.bykowski.springbootbodyparameterized;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ProductApiClient {

    public static void main(String[] args) {
        addProductFromClient();
        getProductForClient();
    }

    private static void addProductFromClient() {
        RestTemplate restTemplate = new RestTemplate();
        String jsonToSent = "{\"name\":\"mouse\",\"price\":5}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity httpEntity = new HttpEntity(jsonToSent, httpHeaders);

        ResponseEntity exchange = restTemplate.exchange(
                "http://localhost:8080/addProduct",
                HttpMethod.POST,
                httpEntity,
                Void.class);
    }

    private static void getProductForClient() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product[]> exchange = restTemplate.exchange(
                "http://localhost:8080/getProductList",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Product[].class);

        Arrays.asList(exchange.getBody()).stream().forEach(System.out::println);
    }
}
