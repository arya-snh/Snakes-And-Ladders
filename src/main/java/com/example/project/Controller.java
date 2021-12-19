package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    private Stage stage;
    private Pane gameScreen;
    private Scene scene;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @FXML
    public void switchToGame(ActionEvent e) throws IOException {

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Rectangle rec = new Rectangle(10,20,30,50);
        Controller c = new Controller();
        StackPane gameScreen = new StackPane();
        gameScreen.getChildren().add(rec);
        Scene scene = new Scene(gameScreen, 450, 600);
        c.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }
}