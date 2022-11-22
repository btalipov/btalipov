package kz.bitlab.btalipov.util;

import kz.bitlab.btalipov.model.Item;

import java.util.ArrayList;

public class DBUtil {

    private static ArrayList<Item> items = new ArrayList<>();

    private static  Long id = 5L;

    static {
        items.add(new Item(1L,"IPhone 14", 40000, 20));
        items.add(new Item(2L,"IPhone 13", 40000, 20));
        items.add(new Item(3L,"IPhone 12", 40000, 20));
        items.add(new Item(4L,"IPhone 11", 40000, 20));
    }

    public static Item addItem(Item item){
        item.setId(id);
        items.add(item);
        id++;
        return item;
    }

    public static Item getItem(Long id){
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().orElseThrow();
    }

    public static ArrayList<Item> getItems(){
        return items;
    }
}
