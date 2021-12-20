package com.example.project;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private ArrayList<Tile> tiles = new ArrayList<>();
    private ArrayList<Snake> snakes = new ArrayList<>();
    private ArrayList<Ladder> ladders = new ArrayList<>();

    Board() {
        for (int i=0; i<101; i++) {
            tiles.add(new Tile(i));
        }
    }
    public Tile getTile(int num) {
        return tiles.get(num);
    }
    public void addSnake(Snake saanp) {
        this.snakes.add(saanp);
    }

    public void addLadder(Ladder seedhi) {
        this.ladders.add(seedhi);
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public ArrayList<Ladder> getLadders() {
        return ladders;
    }
}
