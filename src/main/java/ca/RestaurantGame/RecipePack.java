package ca.RestaurantGame;

import java.util.List;

public class RecipePack {
    String id, name;
    int cost;
    List<String> recipes;
    UnlockCon unlockCondition;

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<String> recipes) {
        this.recipes = recipes;
    }
}
