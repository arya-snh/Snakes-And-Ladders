package com.example.project;

public class SavedGame {
        private int greenTile;
        private int blueTile;
        private boolean isGreenTurn;

    SavedGame(int greenTile, int blueTile, boolean isGreenTurn) {
        this.greenTile = greenTile;
        this.blueTile = blueTile;
        this.isGreenTurn = isGreenTurn;
    }

    public int getGreenTile() {
        return greenTile;
    }

    public void setGreenTile(int greenTile) {
        this.greenTile = greenTile;
    }

    public int getBlueTile() {
        return blueTile;
    }

    public void setBlueTile(int blueTile) {
        this.blueTile = blueTile;
    }

    public boolean isGreenTurn() {
        return isGreenTurn;
    }

    public void setGreenTurn(boolean greenTurn) {
        isGreenTurn = greenTurn;
    }
}
