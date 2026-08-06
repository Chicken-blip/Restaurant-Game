package ca.RestaurantGame;

import java.util.List;

public class CustomerType {
    String type, displayName;
    int patienceBase, patienceVariance, budgetBase, budgetVariance, weight;
    double tipChance, tipMultiplier;
    List<String> preferredFood;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getPatienceBase() {
        return patienceBase;
    }

    public void setPatienceBase(int patienceBase) {
        this.patienceBase = patienceBase;
    }

    public int getPatienceVariance() {
        return patienceVariance;
    }

    public void setPatienceVariance(int patienceVariance) {
        this.patienceVariance = patienceVariance;
    }

    public int getBudgetBase() {
        return budgetBase;
    }

    public void setBudgetBase(int budgetBase) {
        this.budgetBase = budgetBase;
    }

    public int getBudgetVariance() {
        return budgetVariance;
    }

    public void setBudgetVariance(int budgetVariance) {
        this.budgetVariance = budgetVariance;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getTipChance() {
        return tipChance;
    }

    public void setTipChance(double tipChance) {
        this.tipChance = tipChance;
    }

    public double getTipMultiplier() {
        return tipMultiplier;
    }

    public void setTipMultiplier(double tipMultiplier) {
        this.tipMultiplier = tipMultiplier;
    }

    public List<String> getPreferredFood() {
        return preferredFood;
    }

    public void setPreferredFood(List<String> preferredFood) {
        this.preferredFood = preferredFood;
    }
}
