package my_com.seat_reservation_gradle.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import my_com.seat_reservation_gradle.Main;
import my_com.seat_reservation_gradle.constants.FxmlPaths;

import java.io.File;
import java.net.URL;

public class Menu {
    public Menu() {
        System.out.println("Menu");
    }

    @FXML
    AnchorPane anchorPane;

    @FXML
    Hyperlink listLink;
    @FXML
    Hyperlink seatLink;
    @FXML
    Hyperlink reserveLink;
    @FXML
    Hyperlink changeLink;
    @FXML
    Hyperlink cancelLink;

    @FXML
    public void listLinkClicked() throws Exception {
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        URL url = new File(FxmlPaths.LIST.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);


        listLink.getScene().setRoot(root); // Root is rewritten??
    }

    @FXML
    public void seatLinkClicked() throws Exception {
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        URL url = new File(FxmlPaths.SEAT.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void reserveLinkClicked() throws Exception {
//        MenuHamburger.goFxml(listLink, FxmlPaths.RESERVE.getFxmlPath());
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.RESERVE.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void changeLinkClicked() throws Exception {
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        URL url = new File(FxmlPaths.CHANGE.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void cancelLinkClicked() throws Exception {
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        URL url = new File(FxmlPaths.CANCEL.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }


}
