package com.example.project;
import javafx.animation.AnimationTimer;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Timer;

public class Controller {
    private boolean isGreensTurn = true;
    private Stage stage;
    private Scene gameScene;
    private Parent root;
    private double time = 1;
    String player_bar_path;
    private int randInt;
    private SequentialTransition sq = new SequentialTransition();
    boolean isStart = true;
    private SavedGame saved = new SavedGame(0,0,true);

    @FXML
    private Button menu;
    @FXML
    private Button replay;
    @FXML
    private Button dice;
    @FXML
    private Button back;

    @FXML
    private ImageView winnerDialog;
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

    private Dice diceObj = new Dice(3);
    private Player greenPlayer = new Player("Green", 18 ,591);
    private Player bluePlayer = new Player("Blue", 43, 591);
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
        isStart = false;
        sq.getChildren().clear();
        arrow.setOpacity(0);
        randInt = diceObj.roll();
        diceObj.render(diceImg, roll);
        this.addLadderstoBoard();
        this.addSnakesToBoard();

        if (isGreensTurn) {
            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/left-turn.png";
            isGreensTurn = false;
            AnimationTimer timer = new TimerforGreenPlayer();
            timer.start();

            if (greenPlayer.getCurrentTile() == 100) endGame(greenPlayer);
        }

        else {
            AnimationTimer timer = new TimerforBluePlayer();
            timer.start();
            player_bar_path = "file:/C:/Users/tarun/IdeaProjects/ap-project/src/right-turn.png";
            isGreensTurn = true;

            if(bluePlayer.getCurrentTile() ==100) endGame(bluePlayer);
        }

        AnimationTimer timer = new Mytimer();
        timer.start();
    }

    public void endGame(Player winner) {
        System.out.println("ppppp");
        winnerDialog.setOpacity(1);
        menu.toFront();
        replay.toFront();
        back.setDisable(true);
        dice.setDisable(true);

    }

    public void addSnakesToBoard() {
        gameBoard.addSnake(new Snake(gameBoard.getTile(98), gameBoard.getTile(82)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(94), gameBoard.getTile(47)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(92), gameBoard.getTile(71)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(85), gameBoard.getTile(65)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(79), gameBoard.getTile(43)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(68), gameBoard.getTile(50)));
        gameBoard.addSnake(new Snake(gameBoard.getTile(44), gameBoard.getTile(23)));
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
        isStart = true;
        back.setDisable(false);
        dice.setDisable(false);
        winnerDialog.setOpacity(0);
        menu.toBack();
        replay.toBack();
        greenPlayer.setCurrentTile(0);
        bluePlayer.setCurrentTile(0);
    }

    private class Mytimer extends AnimationTimer {
        @Override
        public void handle(long a) {
            fade();
        }

        private void fade() {
            time-=0.007;
            if (time <= 0) {
                time = 1;
                arrow.setOpacity((1));
                Image bar_img = new Image(player_bar_path);
                playerBar.setImage(bar_img);
                stop();
            }
        }
    }

    private class TimerforGreenPlayer extends AnimationTimer {
        @Override
        public void handle(long a) {
            fade();
        }

        private void fade() {
            time-=0.009;
            if (time <= 0) {
                time = 1;
                sq.getChildren().clear();
                sq.setNode(greenPlayerImage);

                greenPlayer.update(randInt, sq, greenPlayerImage);
                sq.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int offset = 0;
                        if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        greenPlayer.render(greenPlayerImage, offset);
                    }
                });
                if (gameBoard.getTile(greenPlayer.getCurrentTile()).isLadderBottom()) {
                    for (Ladder l : gameBoard.getLadders()) {
                        if (l.getStart().getTileNum() == greenPlayer.getCurrentTile()) {
                            greenPlayer.updateLadder(sq, l);
                            break;
                        }
                    }
                }
                if (gameBoard.getTile(greenPlayer.getCurrentTile()).isSnakeHead()) {
                    for (Snake s: gameBoard.getSnakes()) {
                        if (s.getStart().getTileNum() == greenPlayer.getCurrentTile()) {
                            greenPlayer.updateSnake(sq, s);
                            break;
                        }
                    }
                }
                sq.play();
                System.out.println("Green : " + greenPlayer.getCurrentTile());
                stop();
            }
        }
    }

    private class TimerforBluePlayer extends AnimationTimer {
        @Override
        public void handle(long a) {
            fade();
        }

        private void fade() {
            time-=0.009;
            if (time <= 0) {
                time = 1;
                sq.getChildren().clear();

                sq.setNode(bluePlayerImage);
                bluePlayer.update(randInt, sq, bluePlayerImage);
                sq.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        int offset = 0;
                        if (greenPlayer.getCurrentTile() == bluePlayer.getCurrentTile()) offset = 7;
                        bluePlayer.render(bluePlayerImage, offset);
                    }
                });

                if (gameBoard.getTile(bluePlayer.getCurrentTile()).isLadderBottom()) {
                    for (Ladder l : gameBoard.getLadders()) {
                        if (l.getStart().getTileNum() == bluePlayer.getCurrentTile()) {
                            bluePlayer.updateLadder(sq, l);
                            break;

                        }
                    }
                }
                if (gameBoard.getTile(bluePlayer.getCurrentTile()).isSnakeHead()) {
                    for (Snake s: gameBoard.getSnakes()) {
                        if (s.getStart().getTileNum() == bluePlayer.getCurrentTile()) {
                            bluePlayer.updateSnake(sq, s);

                            break;
                        }
                    }
                }

                sq.play();
                System.out.println("Blue : " + bluePlayer.getCurrentTile());
                stop();
            }
        }
    }

    public void handleBoardMouseEntered() {
        if (isStart) resetGame();
    }

}