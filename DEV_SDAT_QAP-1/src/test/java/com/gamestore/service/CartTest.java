package com.gamestore.service;

import com.gamestore.domain.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void testAddGame() {
        Cart cart = new Cart();
        cart.addGame(new Game("Minecraft", 29.99));
        assertFalse(cart.isEmpty());
    }

    @Test
    public void testCalculateTotal() {
        Cart cart = new Cart();
        cart.addGame(new Game("Halo", 39.99));
        cart.addGame(new Game("FIFA", 59.99));
        assertEquals(99.98, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testEmptyCart() {
        Cart cart = new Cart();
        assertTrue(cart.isEmpty());
        assertEquals(0.0, cart.calculateTotal());
    }
}
