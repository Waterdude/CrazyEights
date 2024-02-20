package de.waterdu.crazyeights;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CrazyEightsApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrazyEightsApplication.class.getResource("crazy-eights.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 260);
        stage.setTitle("Crazy Eights");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}