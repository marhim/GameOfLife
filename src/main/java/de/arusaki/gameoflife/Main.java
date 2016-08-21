package de.arusaki.gameoflife;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Mainclass for Conway's Game of Life simulation.
 *
 * @author Marvin Himmelmeier
 * @since 20.08.2016
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameOfLife.fxml"));
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }
}
