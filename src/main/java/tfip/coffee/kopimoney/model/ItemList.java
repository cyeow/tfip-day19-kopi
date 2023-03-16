package tfip.coffee.kopimoney.model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

public class ItemList {
    
    private String quotation_id;
    private List<Item> items;
    public ItemList() {
    }
    public ItemList(String quotation_id, List<Item> items) {
        this.quotation_id = quotation_id;
        this.items = items;
    }
    public String getQuotation_id() {
        return quotation_id;
    }
    public void setQuotation_id(String quotation_id) {
        this.quotation_id = quotation_id;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    @Override
    public String toString() {
        return "ItemList [quotation_id=" + quotation_id + ", items=" + items + "]";
    }

    public static ItemList createFromJSON(String json) {
        JsonObject o = Json.createReader(new StringReader(json)).readObject();

        String quotation_id = o.getString("quotation_id");
        
        List<Item> items = new ArrayList<>();
        JsonArray arr = o.getJsonArray("items");
        arr.forEach((item) -> items.add(Item.createFromJSON(item.asJsonObject())));

        return new ItemList(quotation_id, items);
    }
}
