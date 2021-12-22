package com.example.project;

public class Tunnel extends GameObject{
    protected Tile start;
    protected Tile end;

    Tunnel(Tile a, Tile b) {
        this.start = a;
        this.end = b;
    }

    public Tile getStart() {
        return start;
    }

    public Tile getEnd() {
        return end;
    }
}
