package ca.RestaurantGame;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<String> mealsOrdered;
    double total;
    public Order(CustomerType struct, double budget) {
        mealsOrdered = new ArrayList<>();
        boolean canAfford = true;
        total = 0;
        while (canAfford) {
            for (String dish : struct.getPreferredFood()) {
                if (budget <= 0) {
                    break;
                }
                Recipe r = DataTranslator.recipe_IDToRecipe(dish);
                double cost = 0;
                for (String i : r.ingredients) {
                    cost += DataTranslator.ingredient_IDToIngredient(i).sellPrice;
                }
                cost *= r.markup;
                if (budget < cost) {
                    canAfford = false;
                } else {
                    canAfford = true;
                    total += cost;
                    budget -= cost;
                    mealsOrdered.add(r.id);
                }
            }
        }
    }
    public void receiveMeal(Meal m) {
        mealsOrdered.remove(m.struct.name);
    }
}
