package com.codebase.shopping_basket.helpers;

import com.codebase.shopping_basket.models.Item;

import java.util.ArrayList;
import java.util.List;

public class TotalCostCalculator {

    public static List<Item> sortByPrice(List<Item> items){
        items.sort((a, b) ->
                a.getPrice() > b.getPrice() ? 1 : b.getPrice() > a.getPrice() ? -1 : 0
        );
        return items;
    }

    public static double costAfterBuyOneGetOneFree(List<Item> items, double totalCost){

        double costAfterOffers = totalCost;
        List<Item> copyOfItems = new ArrayList<>();

        if(items.size() % 2 ==0){
            copyOfItems = items.subList(0, (items.size() / 2) );

        } else {
            int sizeRoundedDown = (int) Math.floor(items.size() / 2);
            copyOfItems = items.subList(0, sizeRoundedDown);
        }


        for (Item item : copyOfItems) {
            costAfterOffers -= item.getPrice();
        }

        return costAfterOffers;
    }

    public static double costAfter10PercentDiscount(double totalCost){

        if (totalCost > 20) {
            totalCost *= 0.9;
        }
        return totalCost;
    }

    public static double loyaltyCardDiscount(Boolean hasLoyalyCard, double totalCost){
        if(hasLoyalyCard){
            totalCost *= 0.98;
        }
        return  totalCost;
    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


}
