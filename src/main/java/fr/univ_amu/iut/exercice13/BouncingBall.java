package fr.univ_amu.iut.exercice13;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application {

    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button stopButton;
    private Slider slider;
    private Circle circle;
    private VBox root;
    private HBox commands;
    private Pane pane;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) {

        slider = new Slider(0.5,5,0.5);
        stage.setTitle("Hello !");
        stage.setHeight(500);
        stage.setWidth(250);
        root = new VBox();
        pane = new Pane();

        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        resumeButton = new Button("Resume");
        stopButton = new Button("Stop");
        commands = new HBox();
        commands.setPadding(new Insets(5,0,5,0));

        circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.RED);
        circle.setCenterX(stage.getWidth()/2-5);
        circle.setCenterY(25);

        transition = new TranslateTransition(Duration.millis(1000), circle);
        transition.setFromY(25);
        transition.setToY(400);
        transition.setCycleCount(50000);
        transition.setAutoReverse(true);

        slider.setMinSize(stage.getWidth(),0);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.play();
            }
        });
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.pause();
            }
        });
        resumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.play();
            }
        });
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                transition.stop();
            }
        });

        slider.valueProperty().addListener(
                (observable, oldValue, newValue) -> transition.setRate(newValue.doubleValue()));

        commands.getChildren().addAll(startButton, pauseButton, resumeButton, stopButton);
        commands.setAlignment(Pos.CENTER);
        commands.setSpacing(5);
        root.getChildren().add(commands);
        pane.getChildren().addAll(slider, circle);

        root.getChildren().add(pane);

        Scene scene = new Scene(root, 250, 250);
        stage.setScene(scene);
        stage.show();



    }
}
