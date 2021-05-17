package fr.univ_amu.iut.exercice12;

import fr.univ_amu.iut.exercice9.EcouteurSimple;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label label;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root = new BorderPane();
    private HBox haut;
    private Pane panneau;
    private HBox bas;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(250);
        primaryStage.setWidth(250);

        panneau= new Pane();

        rouge = new Button("Rouge !");
        rouge.setId("redButton");

        vert = new Button("Vert !");
        vert.setId("greenButton");

        bleu = new Button("Bleu !");
        bleu.setId("blueButton");


        EcouteurSimple es = new EcouteurSimple();
        rouge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                panneau.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                nbRouge += 1;
                label.setText("Rouge choisis " + String.valueOf(nbRouge) + " fois");
            }
        });
        vert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                panneau.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                nbVert += 1;
                label.setText("Vert choisis " + String.valueOf(nbVert) + " fois");
            }
        });
        bleu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                panneau.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                nbBleu += 1;
                label.setText("Bleu choisis " + String.valueOf(nbBleu) + " fois");
            }
        });

        FlowPane fp = new FlowPane();
        fp.getChildren().add(vert);
        fp.getChildren().add(rouge);
        fp.getChildren().add(bleu);
        fp.setPrefWrapLength(300);
        fp.setHgap(15);
        fp.setMinHeight(40);
        fp.setAlignment(Pos.CENTER);
        root.setTop(fp);

        label = new Label();

        bas = new HBox();
        bas.getChildren().add(label);
        bas.setAlignment(Pos.CENTER);
        bas.setMinHeight(30);
        bas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        root.setBottom(bas);
        root.setCenter(panneau);


        Scene scene = new Scene(root, 250, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
