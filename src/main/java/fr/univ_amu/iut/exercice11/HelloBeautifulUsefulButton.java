package fr.univ_amu.iut.exercice11;

import fr.univ_amu.iut.exercice9.EcouteurSimple;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloBeautifulUsefulButton extends Application {
    private int nbAction = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello !");
        primaryStage.setHeight(250);
        primaryStage.setWidth(250);

        Button button = new Button("Hello !");
        button.setId("buttonHello");

        Image image = new Image("https://raw.githubusercontent.com/IUTInfoAix-M2105/Syllabus/master/assets/logo.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        button.setGraphic(iv1);

        EcouteurSimple es = new EcouteurSimple();
        button.setOnAction(e -> {
                nbAction += 1;
                System.out.println("Bouton actionné " + String.valueOf(nbAction) + " fois");
        });

        Scene scene = new Scene(button, 250, 250);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("DarkTheme.css").toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
