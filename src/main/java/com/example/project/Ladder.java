package com.example.project;

public class Ladder extends Tunnel{
    Ladder(Tile a, Tile b) {
        super(a, b);
        this.start.setLadderBottom(true);
        this.end.setLadderTop(true);
    }
}
