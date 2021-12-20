package com.example.project;

public class Tile {
    private int tileNum;
    private boolean isSnakeHead = false;
    private boolean isSnakeTail= false;
    private boolean isLadderTop = false;
    private boolean isLadderBottom = false;

    Tile(int num) {
        this.tileNum = num;
    }

    public int getTileNum() {
        return tileNum;
    }

    public void setTileNum(int tileNum) {
        this.tileNum = tileNum;
    }

    public boolean isSnakeHead() {
        return isSnakeHead;
    }

    public void setSnakeHead(boolean snakeHead) {
        isSnakeHead = snakeHead;
    }

    public boolean isSnakeTail() {
        return isSnakeTail;
    }

    public void setSnakeTail(boolean snakeTail) {
        isSnakeTail = snakeTail;
    }

    public boolean isLadderTop() {
        return isLadderTop;
    }

    public void setLadderTop(boolean ladderTop) {
        isLadderTop = ladderTop;
    }

    public boolean isLadderBottom() {
        return isLadderBottom;
    }

    public void setLadderBottom(boolean ladderBottom) {
        isLadderBottom = ladderBottom;
    }
}
