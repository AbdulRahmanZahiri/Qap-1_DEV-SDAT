package com.gamestore.service;

import com.gamestore.domain.Game;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public double calculateTotal() {
        return games.stream().mapToDouble(Game::getPrice).sum();
    }

    public boolean isEmpty() {
        return games.isEmpty();
    }

    public void clear() {
        games.clear();
    }
}