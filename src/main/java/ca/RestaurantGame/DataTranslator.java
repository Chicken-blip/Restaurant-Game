package ca.RestaurantGame;

import java.util.Objects;

public class DataTranslator {
    public static String recipe_IDToName(String ID) {
        for (Recipe r : DataLoader.recipes) {
            if (Objects.equals(r.id, ID)) {
                return r.name;
            }
        }
        return null;
    }

    public static String ingredient_IDToName(String ID) {
        for (Ingredient i : DataLoader.ingredients) {
            if (Objects.equals(i.id, ID)) {
                return i.name;
            }
        }
        return null;
    }

    public String recipe_NameToID(String name) {
        for (Recipe r : DataLoader.recipes) {
            if (Objects.equals(r.name, name)) {
                return r.id;
            }
        }
        return null;
    }
    public static Recipe recipe_IDToRecipe(String ID) {
        for (Recipe r : DataLoader.recipes) {
            if (Objects.equals(r.id, ID)) {
                return r;
            }
        }
        return null;
    }
    public static Recipe recipe_NameToRecipe(String name) {
        for (Recipe r : DataLoader.recipes) {
            if (Objects.equals(r.name, name)) {
                return r;
            }
        }
        return null;
    }
    public static RecipePack recipePack_IDToRecipePack(String ID) {
        for (RecipePack r : DataLoader.recipePacks) {
            if (Objects.equals(r.id, ID)) {
                return r;
            }
        }
        return null;
    }
    public static RecipePack recipePack_NameToRecipePack(String name) {
        for (RecipePack r : DataLoader.recipePacks) {
            if (Objects.equals(r.name, name)) {
                return r;
            }
        }
        return null;
    }
    public static Ingredient ingredient_NameToIngredient(String name) {
        for (Ingredient i : DataLoader.ingredients) {
            if (Objects.equals(i.name, name)) {
                return i;
            }
        }
        return null;
    }
}
