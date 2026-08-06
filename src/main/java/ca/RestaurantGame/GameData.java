package ca.RestaurantGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class GameData {
    int money = 100, serviceNumber = 1;
    List<String> unlocked_packs = new ArrayList<>();
    Map<String, Integer> ingredientStock = new HashMap<>();

    public void save(String filename) throws IOException {
        Properties props = new Properties();
        props.setProperty("money", String.valueOf(money));
        props.setProperty("serviceNum", String.valueOf(serviceNumber));
        props.setProperty("packs", String.join(",", unlocked_packs));

        for (Map.Entry<String, Integer> entry : ingredientStock.entrySet()) {
            props.setProperty("stock_" + entry.getKey(), String.valueOf(entry.getValue()));
        }

        try (FileOutputStream out = new FileOutputStream(filename)) {
            props.store(out, null);
        }
    }

    public void load(String filename) throws IOException {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(filename)) {
            props.load(in);
        }

        money = Integer.parseInt(props.getProperty("money", "100"));
        serviceNumber = Integer.parseInt(props.getProperty("serviceNum", "1"));

        unlocked_packs = new ArrayList<>();
        String packList = props.getProperty("packs", "");
        if (!packList.isEmpty()) {
            unlocked_packs = new ArrayList<>(Arrays.asList(packList.split(",")));
        }

        ingredientStock.clear();
        for (String key : props.stringPropertyNames()) {
            if (key.startsWith("stock_")) {
                String id = key.substring(key.indexOf("_")+1);
                int stock = Integer.parseInt(props.getProperty(key));
                ingredientStock.put(id, stock);
            }
        }

    }
}
