package com.example.project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice extends GameObject{
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



    public void render(ImageView iV) {
        String die = imgPath  + this.currentFace + ".png";
        Image die_img = new Image(die);
        iV.setImage(die_img);
    }
}
