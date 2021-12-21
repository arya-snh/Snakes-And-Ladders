package com.example.project;

import javafx.scene.image.ImageView;

public class Player extends GameObject {
    private double originX = 23;
    private double originY = 45;
    private double box_height =(542/10.0) - 1;
    private double box_width = (386/10.0) - 1;

    private String color;
    private int currentTile = 0;
    private double X;
    private double Y;
    private boolean isActive = false;

    Player(String color) {
        super();
        this.color = color;

    }

    public void update(int inc) {
        if (inc == 1) isActive = true;

        if (!isActive) inc = 0;
        this.currentTile += inc;

        if(this.currentTile > 100) this.currentTile -= inc;

        int yRowIndex = 9 - (int) Math.floor((this.currentTile-1)/10);
        this.Y = originY + yRowIndex * box_height;
        int xRowIndex = (this.currentTile - 1) % 10;

        if (yRowIndex % 2 != 0) {
            this.X = originX + xRowIndex * box_width;
        } else {
            this.X = originX +  386 -  xRowIndex * box_width - 45;
        }
    }


    public void render(ImageView iV, int offset) {
        if (isActive) {
            iV.setLayoutY(this.Y + 20 + offset);
            iV.setLayoutX(this.X + 10 + offset * 0.7);
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public int getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(int currentTile) {
        this.currentTile = currentTile;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }
}
