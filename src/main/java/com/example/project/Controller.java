package com.example.project;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {
    private boolean isGreensTurn = true;
    private Stage stage;
    private Scene gameScene;
    private Parent root;
    private double time = 1;
    String player_bar_path;

    @FXML
    private ImageView grid;

    @FXML
    private ImageView greenPlayerImage;
    @FXML
    private ImageView bluePlayerImage;

    @FXML
    private ImageView playerBar;
    @FXML
    private ImageView diceImg;
    @FXML
    private ImageView roll;
    @FXML
    private ImageView arrow;

    private Dice dice = new Dice(3);
    private Player greenPlayer = new Player("Green");
    private Player bluePlayer = new Player("Blue");
    private Board gameBoard = new Board();




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
    }

    public void handleDiceClick(ActionEvent e) throws IOException{
        arrow.setOpacity(0);
        TranslateTransition move = new TranslateTransition();
        int offset = 0;
        int randInt = dice.roll();
        dice.render(diceImg, roll);
        this.addLadderstoBoard();
        this.addSnakesToBoard();


        if (isGreensTurn) {

            greenPlayer.update(randInt);
            if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
            greenPlayer.render(greenPlayerImage, move, offset);

            System.out.println("Green player is at " + greenPlayer.getCurrentTile());
            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/left-turn.png";
            isGreensTurn = false;

            if (gameBoard.getTile(greenPlayer.getCurrentTile()).isLadderBottom()) {
                for (Ladder l : gameBoard.getLadders()) {
                    if (l.getStart().getTileNum() == greenPlayer.getCurrentTile()) {
                        greenPlayer.update(l.getEnd().getTileNum() - l.getStart().getTileNum());
                        if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        greenPlayer.render(greenPlayerImage, move, offset);
                        break;

                    }
                }
            }
            if (gameBoard.getTile(greenPlayer.getCurrentTile()).isSnakeHead()) {
                for (Snake s: gameBoard.getSnakes()) {
                    if (s.getStart().getTileNum() == greenPlayer.getCurrentTile()) {
                        greenPlayer.update((s.getEnd().getTileNum() - s.getStart().getTileNum()));
                        if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        greenPlayer.render(greenPlayerImage, move, offset);
                        break;
                    }
                }
            }
        }
        else {

            bluePlayer.update(randInt);
            if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
            bluePlayer.render(bluePlayerImage, move, offset);

            System.out.println("Blue player is at " + bluePlayer.getCurrentTile());
            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/right-turn.png";
            isGreensTurn = true;

            if (gameBoard.getTile(bluePlayer.getCurrentTile()).isLadderBottom()) {
                for (Ladder l : gameBoard.getLadders()) {
                    if (l.getStart().getTileNum() == bluePlayer.getCurrentTile()) {
                        bluePlayer.update(l.getEnd().getTileNum() - l.getStart().getTileNum());
                        if (bluePlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        bluePlayer.render(bluePlayerImage, move, offset);
                        break;

                    }
                }
            }
            if (gameBoard.getTile(bluePlayer.getCurrentTile()).isSnakeHead()) {
                for (Snake s: gameBoard.getSnakes()) {
                    if (s.getStart().getTileNum() == bluePlayer.getCurrentTile()) {
                        bluePlayer.update((s.getEnd().getTileNum() - s.getStart().getTileNum()));
                        if (bluePlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        bluePlayer.render(bluePlayerImage, move, offset);
                        break;
                    }
                }
            }

        }
        AnimationTimer timer = new Mytimer();
        timer.start();
    }

    public void addSnakesToBoard() {
        gameBoard.addSnake(new Snake(gameBoard.getTile(98), gameBoard.getTile(82)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(94), gameBoard.getTile(47)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(92), gameBoard.getTile(71)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(85), gameBoard.getTile(65)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(79), gameBoard.getTile(43)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(68), gameBoard.getTile(50)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(44), gameBoard.getTile(53)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(33), gameBoard.getTile(8)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(15), gameBoard.getTile(5)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(22), gameBoard.getTile(2)));
    }

    public void addLadderstoBoard() {
        gameBoard.addLadder(new Ladder((gameBoard.getTile(3)), gameBoard.getTile(24)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(7)), gameBoard.getTile(34)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(12)), gameBoard.getTile(31)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(20)), gameBoard.getTile(41)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(36)), gameBoard.getTile(46)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(56)), gameBoard.getTile(63)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(60)), gameBoard.getTile(81)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(69)), gameBoard.getTile(93)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(75)), gameBoard.getTile(95)));
        gameBoard.addLadder(new Ladder((gameBoard.getTile(78)), gameBoard.getTile(97)));
    }

    public void resetGame() {
        greenPlayer.setCurrentTile(0);
        bluePlayer.setCurrentTile(0);
    }

    private class Mytimer extends AnimationTimer {
        @Override
        public void handle(long a) {
            fade();
        }

        private void fade() {
            time-=0.005;
            if (time <= 0) {
                time = 1;
                arrow.setOpacity((1));
                Image bar_img = new Image(player_bar_path);
                playerBar.setImage(bar_img);
                stop();
            }
        }
    }

}