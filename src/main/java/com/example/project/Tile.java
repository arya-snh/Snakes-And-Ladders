package com.example.project;

public class Tile extends GameObject{
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

    public boolean isSnakeHead() {
        return isSnakeHead;
    }

    public void setSnakeHead(boolean snakeHead) {
        isSnakeHead = snakeHead;
    }

    public void setSnakeTail(boolean snakeTail) {
        isSnakeTail = snakeTail;
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
