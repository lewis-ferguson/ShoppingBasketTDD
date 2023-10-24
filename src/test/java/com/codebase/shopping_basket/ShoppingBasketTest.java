package com.codebase.shopping_basket;

import com.codebase.shopping_basket.models.Item;
import com.codebase.shopping_basket.models.ShoppingBasket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket = new ShoppingBasket();
    Item item = new Item("Banana", 1.10);
    Item item2 = new Item("Apple", 21);

    @BeforeEach
    public void before() {
        shoppingBasket.empty();
    }

    @Test
    public void canAddItem(){
        shoppingBasket.addItem(item);
        assertEquals(1, shoppingBasket.getItems().size());
    }

    @Test
    public void canRemoveItem() {
        shoppingBasket.addItem(item);
        shoppingBasket.removeItem(item);
        assertEquals(0,shoppingBasket.getItems().size());
    }

    @Test
    public void canEmptyBasket() {
        shoppingBasket.addItem(item);
        shoppingBasket.empty();
        assertEquals(0, shoppingBasket.getItems().size());


    }

    @Test
    public void canBuyOneGetOneFree() {
        shoppingBasket.addItem(item);
        shoppingBasket.addItem(item);
        assertEquals(1.10, shoppingBasket.getTotalCost(), 0.0);
    }

    @Test
    public void canGet10PercentOffOver20() {
        shoppingBasket.addItem(item2);
        assertEquals(18.9, shoppingBasket.getTotalCost(), 0.0);
    }

    @Test
    public void canGet2PercentDiscountWithLoyaltyCard() {
        shoppingBasket.addItem(item2);
        shoppingBasket.setLoyaltyCard(true);
        assertEquals(18.52, shoppingBasket.getTotalCost(), 0.0);
    }

    @Test
    public void canGetAllDiscounts() {
        shoppingBasket.addItem(item2);
        shoppingBasket.addItem(item2);
        shoppingBasket.addItem(item);
        shoppingBasket.addItem(item);
        shoppingBasket.setLoyaltyCard(true);
        assertEquals(37.04, shoppingBasket.getTotalCost(), 0.0);
    }
}
