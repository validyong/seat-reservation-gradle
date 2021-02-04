package my_com.seat_reservation_gradle.controllers;

import my_com.seat_reservation_gradle.Main;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class WindowController {

    private double xOffset = 0;
    private double yOffset = 0;
    public Stage stage;


    public WindowController(Stage stage, Parent parent) {
        this.stage = stage;

        parent.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        parent.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }

    public static void setStaticWindow(Parent parent) {
        AtomicReference<Double> testXOffset = new AtomicReference<>((double) 0);
        double testYOffset = 0;

        Stage testStage = Main.getPrimaryStage();
        parent.setOnMousePressed(event -> {
            testXOffset.set(event.getSceneX());
            testXOffset.set(event.getSceneY());
        });

        parent.setOnMouseDragged(event -> {
            testStage.setX(event.getScreenX() - testXOffset.get());
            testStage.setY(event.getScreenY() - testXOffset.get());
        });

        Main.setPrimaryStage(testStage);
    }

}
