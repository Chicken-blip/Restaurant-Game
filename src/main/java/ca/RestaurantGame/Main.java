package ca.RestaurantGame;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameData game = new GameData();
        DataLoader.loadAll();
        UIDisplay display = new UIDisplay(game);
        //Start of the game - only add the Starter Pack
        display.recipePacks.addElement(DataLoader.recipePacks.get(0).name);
        //Load all ingredients
        for (Ingredient i : DataLoader.ingredients) {
            display.ingredients.addElement(i.name);
        }


        display.showPanel(UINames.RECIPE_PACK_PURCHASING);
        display.setVisible(true);
    }
}