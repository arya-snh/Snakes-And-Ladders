package com.example.project;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Dice extends GameObject{
    private double time = 1;
    private ImageView roll;
    private int currentFace;
    private static String imgPath = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/die-";

    Dice(int faceNumber) {
        super();
        this.currentFace = faceNumber;

    }
    public int roll() {
        int cf = (int) Math.floor(6 * Math.random() +1);
        this.currentFace = cf;
        return cf;
    }

    public void render(ImageView dice, ImageView roll) {
        this.roll = roll;
        AnimationTimer timer = new Mytimer();
        roll.setOpacity(1);
        timer.start();

        String die = imgPath  + this.currentFace + ".png";
        Image die_img = new Image(die);
        dice.setImage(die_img);
    }

    private class Mytimer extends AnimationTimer {
        @Override
        public void handle(long a) {
            fade();
        }
        private void fade() {
            time-=0.01;
            if (time <= 0) {
                roll.setOpacity(0);
                time = 1;
                stop();
            }
        }
    }
}
