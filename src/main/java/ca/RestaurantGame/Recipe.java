package ca.RestaurantGame;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String id, name;
    List<String> ingredients = new ArrayList<>();
    List<String> instructions = new ArrayList<>();
    double markup;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public List<String> getInstructions() {
        return instructions;
    }
    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
    public double getMarkup() {
        return markup;
    }
    public void setMarkup(double markup) {
        this.markup = markup;
    }
}
