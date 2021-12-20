package com.example.project;

public class Tunnel {
    protected Tile start;
    protected Tile end;

    Tunnel(Tile a, Tile b) {
        this.start = a;
        this.end = b;
    }

    public Tile getStart() {
        return start;
    }

    public void setStart(Tile start) {
        this.start = start;
    }

    public Tile getEnd() {
        return end;
    }

    public void setEnd(Tile end) {
        this.end = end;
    }
}
