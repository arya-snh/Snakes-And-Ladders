package com.example.project;
import java.io.*;
import java.lang.Thread;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private boolean isRightTurn = true;
    private Stage stage;
    private Scene gameScene;
    private Parent root;
    private static int blueSqNumber = 0;
    private static int greenSqNumber = 1;

    @FXML
    private ImageView grid;

    @FXML
    private ImageView greenPlayer;

    @FXML
    private ImageView playerBar;
    @FXML
    private ImageView diceImg;

    public void switchtoMenu(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
    }

    public void switchtoGame(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        gameScene = new Scene(root);
        stage.setScene(gameScene);
        stage.show();
        //boxes.add(r0);
    }



    public void handleDiceClick(ActionEvent e) throws IOException{
        double originX = 23;
        double originY = 45;
        double box_height =(grid.getFitHeight()/10.0) - 1;
        double box_width = (grid.getFitWidth()/10.0) - 1 ;
        double greenY=0, greenX=0, blueY, blueX;

        int randInt = (int) Math.floor(6 * Math.random() +1);
        //file:/C:/Users/tarun/IdeaProjects/ap-project/src/die-3.png
        String die = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/" + "die-" + randInt + ".png";
        Image die_img = new Image(die);
        diceImg.setImage(die_img);

        String player_bar_path;
        if (isRightTurn) {
            //green's turn
            greenSqNumber += randInt;

            int yRowIndex = 9 - (int) Math.floor((greenSqNumber-1)/10);
            greenY = originY + yRowIndex * box_height;
            int xRowIndex = (greenSqNumber - 1) % 10;

            if (yRowIndex % 2 != 0) {
                greenX = originX + xRowIndex * box_width;
            } else {
                greenX = originX +  grid.getFitWidth() -  xRowIndex * box_width - 45;

            }

            greenPlayer.setLayoutX(greenX + 10);
            greenPlayer.setLayoutY(greenY + 20);

            System.out.println("Player is at " + greenSqNumber);



            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/left-turn.png";
            isRightTurn = false;
        }
        else {
            //blue's turn
//            blueSqNumber += randInt;
//            System.out.println("Blue is at " + blueSqNumber +"\n");
//            blueY = Math.floor((blueSqNumber-1)/10)*box_height;
//            bluePlayer.setTranslateY(-blueY);
            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/right-turn.png";
            isRightTurn = true;
        }
        Image bar_img = new Image(player_bar_path);
        playerBar.setImage(bar_img);



    }
}