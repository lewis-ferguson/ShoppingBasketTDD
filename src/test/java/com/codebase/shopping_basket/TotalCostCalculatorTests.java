package com.codebase.shopping_basket;
import com.codebase.shopping_basket.helpers.TotalCostCalculator;
import com.codebase.shopping_basket.models.Item;
import com.codebase.shopping_basket.models.ShoppingBasket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TotalCostCalculatorTests {

    List<Item> items = new ArrayList<>();
    Item item = new Item("Banana", 1.10);
    Item item2 = new Item("Apple", 21);


    @BeforeEach
    public void before() {

        items.add(item);
        items.add(item2);
        items.add(item);
        items.add(item2);
    }

    @Test
    public void canSortListByPrice(){
        List<Item> sortedList = TotalCostCalculator.sortByPrice(items);
        List<Item> expectedList = new ArrayList<>();
        expectedList.add(item);
        expectedList.add(item);
        expectedList.add(item2);
        expectedList.add(item2);
        assertEquals(expectedList, sortedList);
    }


}
