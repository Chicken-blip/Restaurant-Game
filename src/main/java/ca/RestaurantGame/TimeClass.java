package ca.RestaurantGame;

import javax.swing.*;
import java.util.Map;

public class TimeClass {
    UIDisplay ui;
    public TimeClass(UIDisplay ui) {
        this.ui = ui;
    }
    static int customerCountdown = 10;
    Timer serviceTimer = new Timer(1000, e -> {
        // This runs every 1 second (1000ms)
        customerCountdown--;
        if (customerCountdown < 0 && Math.random() < 0.1) {
            ui.addCustomer();
            customerCountdown = 10;
        }
        //Check if all items in their order were complete or if their patience runs out
        for (Customer c : ui.customersByName.values()) {
            if (c.patience == 0) {
                ui.game.customersLost++;
                //Remove Customer object
                for (Map.Entry<String, Customer> entry : ui.customersByName.entrySet()) {
                    if (entry.getValue() == c) {
                        ui.customers.removeElement(entry.getKey());
                        ui.customersByName.remove(entry.getKey());
                        break;
                    }
                }
            } else {
                c.patience--;
                if (c.order.mealsOrdered.isEmpty()) {
                    //All meals served
                    //Pay out money + tip if applicable
                    double tip = 0;
                    if (Math.random() < c.struct.tipChance) {
                        tip = c.order.total * c.struct.tipMultiplier;
                    }
                    ui.game.money += c.order.total + tip;
                    //Remove Customer object
                    for (Map.Entry<String, Customer> entry : ui.customersByName.entrySet()) {
                        if (entry.getValue() == c) {
                            ui.customers.removeElement(entry.getKey());
                            ui.customersByName.remove(entry.getKey());
                            break;
                        }
                    }
                }
            }
        }
    });
}
