package tfip.coffee.kopimoney.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import tfip.coffee.kopimoney.model.Item;
import tfip.coffee.kopimoney.model.ItemList;

@Service
public class CoffeeService {

    // @Value("${tfip.coffee.local.restcontroller.host}")
    // String host;

    // @Value("${tfip.coffee.local.restcontroller.port}")
    // String port;

    @Value("${tfip.coffee.local.restcontroller.url}")
    String url;

    public Item createNewItem(Item item) {
        String getUrl = UriComponentsBuilder
                .fromUriString(url)
                .path("/pingkenneth")
                .queryParam("username", item.getUsername())
                .queryParam("name", item.getName())
                .queryParam("price", item.getPrice())
                .toUriString();

        RequestEntity<Void> req = RequestEntity.get(getUrl).build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        return Item.createFromJSON(resp.getBody());
    }

    public List<Item> getAllItems() {
        String getUrl = UriComponentsBuilder
                .fromUriString(url)
                .path("/get-all")
                .toUriString();

        RequestEntity<Void> req = RequestEntity.get(getUrl).build();

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        return ItemList.createFromJSON(resp.getBody()).getItems();
    }
}
