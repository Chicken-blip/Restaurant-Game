package ca.RestaurantGame;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataLoader {
    static List<Ingredient> ingredients;
    static List<Recipe> recipes;
    static List<RecipePack> recipePacks;
    static List<CustomerType> customerTypes;

    public static void loadAll() {
        loadIngredients();
        loadRecipes();
        loadRecipePacks();
        loadCustomerTypes();
    }
    private static void loadIngredients() {
        try {
            ObjectMapper mp = new ObjectMapper();
            InputStream input = DataLoader.class.getResourceAsStream("/data/ingredients.json");
            ingredients = mp.readValue(input, new TypeReference<List<Ingredient>>(){});
        } catch (IOException e) {
            System.err.println("Failed to load ingredients...\n" + e.getMessage());
        }
    }

    private static void loadRecipes() {
        try {
            ObjectMapper mp = new ObjectMapper();
            InputStream input = DataLoader.class.getResourceAsStream("/data/recipes.json");
            recipes = mp.readValue(input, new TypeReference<List<Recipe>>(){});
        } catch (IOException e) {
            System.err.println("Failed to load recipes...\n" + e.getMessage());
        }
    }

    private static void loadRecipePacks() {
        try {
            ObjectMapper mp = new ObjectMapper();
            InputStream input = DataLoader.class.getResourceAsStream("/data/recipe_packs.json");
            recipePacks = mp.readValue(input, new TypeReference<List<RecipePack>>(){});
        } catch (IOException e) {
            System.err.println("Failed to load recipe packs...\n" + e.getMessage());
        }
    }

    private static void loadCustomerTypes() {
        try {
            ObjectMapper mp = new ObjectMapper();
            InputStream input = DataLoader.class.getResourceAsStream("/data/customers.json");
            customerTypes = mp.readValue(input, new TypeReference<List<CustomerType>>(){});
        } catch (IOException e) {
            System.err.println("Failed to load customer types...\n" + e.getMessage());
        }
    }
}
