package my_com.seat_reservation_gradle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import my_com.seat_reservation_gradle.constants.FxmlPaths;
import my_com.seat_reservation_gradle.controllers.WindowController;

import java.io.File;
import java.net.URL;


public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File(FxmlPaths.MENU.getFxmlPath()).toURI().toURL();
        System.out.println("url: " + url);

        System.out.println(getClass().getResource("").getFile());
        System.out.println(getClass().getResource("").getClass());
        System.out.println(FxmlPaths.MENU.getFxmlPath());

        System.out.println(getClass().getResource(FxmlPaths.MENU.getFxmlPath()));
        Parent root = FXMLLoader.load(url);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        WindowController menu = new WindowController(primaryStage, root);

        Scene scene = new Scene(root);
        Main.primaryStage = primaryStage;

        menu.stage.setScene(scene);

        menu.stage.show();

    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }

}
