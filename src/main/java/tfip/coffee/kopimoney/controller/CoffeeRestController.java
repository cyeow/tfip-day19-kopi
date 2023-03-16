package tfip.coffee.kopimoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfip.coffee.kopimoney.model.Item;
import tfip.coffee.kopimoney.service.CoffeeRestService;

@RestController
@RequestMapping(path="api")
public class CoffeeRestController {

    @Autowired
    CoffeeRestService svc;

    @GetMapping("/pingkenneth")
    public ResponseEntity<String> pingKennethAPI(@RequestParam(defaultValue = "cyeow") String username,
            @RequestParam(defaultValue = "Milo") String name, @RequestParam(defaultValue = "4.3d") Double price) {
        String resp = svc.pingKenneth(new Item(name, price, username));

        if (resp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/get-all")
    public ResponseEntity<String> retrieveAllitems() {
        String resp = svc.retrieveItems();

        if (resp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
