package com.codebase.shopping_basket.models;

import com.codebase.shopping_basket.helpers.TotalCostCalculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class ShoppingBasket {

    private final ArrayList<Item> items;
    private Boolean loyaltyCard;

    public ShoppingBasket() {
        this.items = new ArrayList<>();
        this.loyaltyCard = false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public Boolean getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(Boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void empty() {
        this.items.clear();
    }

    public double getTotalCost() {

        double totalCost = 0;


        //This sorts the list of items in the basket by price in ascending order
        List<Item> sortedItems = TotalCostCalculator.sortByPrice(this.getItems());


        //Find the total cost of all items before any discounts
        for(Item item: sortedItems){
            totalCost += item.getPrice();
        }

        //Returns the cost after buy one get one free (cheapest items are free)
        double costAfterBuyOneGetOneFree = TotalCostCalculator.costAfterBuyOneGetOneFree(sortedItems, totalCost);

        //Returns the new total with 10% discount if the value of items is over £20
        double costAfter10PercentDiscount = TotalCostCalculator.costAfter10PercentDiscount(costAfterBuyOneGetOneFree);

        //Returns the new total if the customer has a loyalty card with a further 2% discount
        double finalCost = TotalCostCalculator.loyaltyCardDiscount(this.getLoyaltyCard(), costAfter10PercentDiscount);

        //returns the final cost rounded to 2 decimal places
        return  TotalCostCalculator.round(finalCost,2);
    }

}
