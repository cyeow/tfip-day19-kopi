package tfip.coffee.kopimoney.model;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Item {
    private String name;
    private Double price;
    private String username;
    private String id;
    private Long dt;

    public Item() {
    }

    public Item(String name, Double price, String username) {
        this.name = name;
        this.price = price;
        this.username = username;
    }

    public Item(String name, Double price, String username, String id, Long dt) {
        this.name = name;
        this.price = price;
        this.username = username;
        this.id = id;
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + ", username=" + username + ", id=" + id + ", dt=" + dt + "]";
    }

    public boolean isEmpty() {
        if (this.getName() == null &&
                this.getPrice() == null &&
                this.getUsername() == null &&
                this.getId() == null &&
                this.getDt() == null) {
            return true;
        }
        return false;
    }

    public JsonObject toJSON(String newUsername) {
        return Json.createObjectBuilder()
                .add("name", this.getName())
                .add("price", this.getPrice())
                .add("username", newUsername)
                .build();
    }

    public JsonObject toJSON() {
        return toJSON(this.getUsername());
    }

    public static Item createFromJSON(String json) {
        JsonObject o = Json.createReader(new StringReader(json)).readObject();

        return createFromJSON(o);
    }

    public static Item createFromJSON(JsonObject o) {
        String name = o.getString("name");
        Double price = o.getJsonNumber("price").doubleValue();
        String username = o.getString("username");
        String id = o.getString("id");
        Long dt = Long.parseLong(o.getString("dt"));

        return new Item(name, price, username, id, dt);
    }

}
