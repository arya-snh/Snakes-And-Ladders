package com.example.project;

public class Snake extends Tunnel{
    Snake(Tile a, Tile b) {
        super(a, b);
        this.start.setSnakeHead(true);
        this.end.setSnakeTail(true);
    }

}
