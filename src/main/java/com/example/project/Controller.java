package com.example.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    private Stage stage;
    private Pane gameScreen;
    private Scene scene;

    @FXML
    public void switchToGame(ActionEvent e) throws IOException {

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();


        StackPane gameScreen = new StackPane();
        setupGameScreen(gameScreen);
        Scene scene = new Scene(gameScreen, 450, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void setupGameScreen(StackPane pane) throws IOException {

        // Back button setup
        Button backButton = new Button("<-");
        backButton.setTranslateX(-180);
        backButton.setTranslateY(-260);
        pane.getChildren().add(backButton);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        backButton.setOnAction(e -> stage.setScene(scene));

        // Board setup
        //Image img = new Image("gameBoard.png");

    }
}