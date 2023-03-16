package tfip.coffee.kopimoney.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tfip.coffee.kopimoney.model.Item;

@Service
public class CoffeeRestService {

    @Value("${tfip.coffee.quotation.production.url}")
    String qpUrl;

    public String pingKenneth(Item item) {

        RequestEntity<String> req = RequestEntity.post(qpUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(item.toJSON().toString(), String.class);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        return resp.getBody();
    }

    public String retrieveItems() {
        RequestEntity<Void> req = RequestEntity
                .get(qpUrl)
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        return resp.getBody();
    }
}
