package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class HelloLabel extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label text = new Label("Hello !");
        text.setId("labelHello");
        //Setting the text to be added.
        text.setText("Hello !");


        //Creating a Group object
        Group root = new Group(text);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(100);
        primaryStage.setWidth(250);

        primaryStage.show();

    }
}
