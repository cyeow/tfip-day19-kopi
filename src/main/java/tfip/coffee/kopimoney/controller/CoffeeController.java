package tfip.coffee.kopimoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import tfip.coffee.kopimoney.model.Item;
import tfip.coffee.kopimoney.service.CoffeeService;

@Controller
public class CoffeeController {
    
    @Autowired
    CoffeeService svc;
    
    @GetMapping(path="/")
    public String indexPage(Model model, @ModelAttribute Item item) {
        if(item == null || item.isEmpty()) {
            model.addAttribute("item", new Item("Milo", 4.3d, "cyeow"));
            model.addAttribute("result", null);
        } else {
            System.out.println(item);
            Item result = svc.createNewItem(item);
            model.addAttribute("item", item);
            model.addAttribute("result", result);
        }

        return "index";
    }

    @GetMapping(path="/show-all")
    public String listAll(Model model) {
        model.addAttribute("itemlist", svc.getAllItems());
        return "list";
    }
}
