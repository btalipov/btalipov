package kz.bitlab.btalipov.controllers;

import kz.bitlab.btalipov.model.Item;
import kz.bitlab.btalipov.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model){

        ArrayList<Item> items = DBUtil.getItems();
        model.addAttribute("tovary",items);

        return "index";
    }
    @GetMapping(value = "/additem")
    public String addItem(Model model){
        return "additem";
    }


    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "item_name") String name,
                          @RequestParam(name = "item_price") double price,
                          @RequestParam(name = "item_amount") int amount){

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);

        DBUtil.addItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{itemId}")
    public String details(@PathVariable(name = "itemId") Long id, Model model){
        Item item = DBUtil.getItem(id);
        model.addAttribute("tovar",item);
        return "details";
    }
}
