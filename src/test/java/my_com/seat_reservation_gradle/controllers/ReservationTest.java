package my_com.seat_reservation_gradle.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import my_com.seat_reservation_gradle.constants.FxmlPaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.net.URL;

public class ReservationTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File(FxmlPaths.RESERVE.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.initStyle(StageStyle.TRANSPARENT);
        WindowController menu = new WindowController(stage, root);

        Scene scene = new Scene(root);

        menu.stage.setScene(scene);

        menu.stage.show();
    }

    @Before
    public void setUp () throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testClickListLick() {
        clickOn("#firstName");
        write("testJohn");
        clickOn("#lastName");
        write("testDoe");
        clickOn("#male");
        clickOn("#reserveButton");

    }
}