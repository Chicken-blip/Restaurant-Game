package ca.RestaurantGame;

public class Customer {
    CustomerType struct;
    boolean orderTaken;
    Order order;
    int patienceMax, patience;
    double budget;
    public Customer(GameData g) {
        struct = DataLoader.customerTypes.get((int) (Math.random() * DataLoader.customerTypes.size()));
        if (canOrder(g)) {
            orderTaken = false;
            //Select their patience
            int patienceBase = struct.getPatienceBase() - struct.getPatienceVariance();
            patienceMax = patienceBase + (int) (Math.random() * (2 * struct.getPatienceVariance()));
            //Select a budget
            double budgetBase = struct.getBudgetBase() - struct.getBudgetVariance();
            budget = (budgetBase + (int) (Math.random() * (2 * struct.getBudgetVariance())));
            //Setup order
            order = new Order(this.struct, budget);
            patience = patienceMax;
        } else {
            order = null;
        }
    }
    public boolean canOrder(GameData g) {
        if (!struct.getPreferredFood().isEmpty()) {
            for (String r_id : struct.getPreferredFood()) {
                for (String rp_id : g.unlocked_packs) {
                    if (DataTranslator.recipePack_IDToRecipePack(rp_id).recipes.contains(r_id)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
