package my_com.seat_reservation_gradle.controllers;

import my_com.seat_reservation_gradle.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuHamburger {
    public static void goFxml(Hyperlink hyperlink, String fxmlStr) throws IOException {
        Stage stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(new URL(fxmlStr));

        WindowController list = new WindowController(stage, root);


        hyperlink.getScene().setRoot(root);
    }
}
