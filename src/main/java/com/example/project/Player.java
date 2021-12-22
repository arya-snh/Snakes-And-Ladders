package com.example.project;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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

    Player(String color, int x, int y) {
        super();
        this.color = color;
        this.X = x;
        this.Y = y;
    }

    public void update(int inc, SequentialTransition sq, ImageView img) {
        double prevX, prevY;

        if (inc == 1) isActive = true;
        if (!isActive) inc = 0;

        if(this.currentTile + inc > 100) return;

        for (int i = 0; i < inc; i++) {
            this.currentTile++;
            prevX = this.X;
            prevY = this.Y;

            int yRowIndex = 9 - (int) Math.floor((this.currentTile-1)/10);
            this.Y = originY + yRowIndex * box_height + 20;
            int xRowIndex = (this.currentTile - 1) % 10;

            if (yRowIndex % 2 != 0) {
                this.X = originX + xRowIndex * box_width + 10;
            } else {
                this.X = originX +  386 -  xRowIndex * box_width - 45 + 10;
            }

            TranslateTransition tra = new TranslateTransition();
            tra.setNode(img);
            tra.setDuration(Duration.seconds(0.6));
            tra.setByX(this.X- prevX);
            tra.setByY(this.Y- prevY);
            sq.getChildren().add(tra);
            sq.getChildren().add(new PauseTransition(Duration.seconds(0.05)));
        }

    }

    public void updateLadder(SequentialTransition sq, Ladder ladder) {
        double x1, y1;
        int yRowIndex = 9 - (int) Math.floor((ladder.getEnd().getTileNum()-1)/10);
        y1 = originY + yRowIndex * box_height + 20;
        int xRowIndex = (ladder.getEnd().getTileNum() - 1) % 10;

        if (yRowIndex % 2 != 0) {
            x1 = originX + xRowIndex * box_width + 10;
        } else {
            x1 = originX +  386 -  xRowIndex * box_width - 45 + 10;
        }

        sq.getChildren().add(new PauseTransition(Duration.seconds(0.05)));

        TranslateTransition tra = new TranslateTransition();
        tra.setNode(sq.getNode());
        tra.setDuration(Duration.seconds(0.5));
        tra.setByX(x1 - this.X);
        tra.setByY(y1 - this.Y);
        sq.getChildren().add(tra);
        sq.getChildren().add(new PauseTransition(Duration.seconds(0.05)));

        this.currentTile = ladder.end.getTileNum();
        this.Y = y1;
        this.X = x1;
    }

    public void updateSnake(SequentialTransition sq, Snake snake) {
        double x1, y1;
        int yRowIndex = 9 - (int) Math.floor((snake.getEnd().getTileNum()-1)/10);
        y1 = originY + yRowIndex * box_height + 20;
        int xRowIndex = (snake.getEnd().getTileNum() - 1) % 10;

        if (yRowIndex % 2 != 0) {
            x1 = originX + xRowIndex * box_width + 10;
        } else {
            x1 = originX +  386 -  xRowIndex * box_width - 45 + 10;
        }

        sq.getChildren().add(new PauseTransition(Duration.seconds(0.5)));

        TranslateTransition tra = new TranslateTransition();
        tra.setNode(sq.getNode());
        tra.setDuration(Duration.seconds(1));
        tra.setByX(x1 - this.X);
        tra.setByY(y1 - this.Y);
        sq.getChildren().add(tra);
        sq.getChildren().add(new PauseTransition(Duration.seconds(0.1)));

        this.currentTile = snake.end.getTileNum();
        this.Y = y1;
        this.X = x1;
    }


    public void render(ImageView iV, int offset) {
        if (isActive) {
            iV.setLayoutY(this.Y + offset);
            iV.setTranslateY(0);
            iV.setLayoutX(this.X + offset * 0.7);
            iV.setTranslateX(0);

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

    public boolean getIsActive() {
        return isActive;
    }


}
