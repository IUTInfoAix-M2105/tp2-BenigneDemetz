package fr.univ_amu.iut.exercice8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloBeautifulButton extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(250);
        primaryStage.setWidth(250);

        Button button = new Button("Hello !");
        button.setId("buttonHello");

        Scene scene = new Scene(button, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
