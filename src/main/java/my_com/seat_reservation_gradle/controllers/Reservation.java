package my_com.seat_reservation_gradle.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import my_com.seat_reservation_gradle.Main;
import my_com.seat_reservation_gradle.constants.FxmlPaths;
import my_com.seat_reservation_gradle.models.ReserveSeatChooser;
import my_com.seat_reservation_gradle.models.Seat;
import my_com.seat_reservation_gradle.models.SeatEditor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Reservation {
    public Reservation() {
        System.out.println("Reserve");
    }

    @FXML
    AnchorPane anchorPane;
    @FXML
    Hyperlink menuLink, listLink, seatLink, reserveLink, changeLink, cancelLink;

    @FXML
    VBox form;

    @FXML
    JFXButton reserveButton;

    @FXML
    JFXTextField firstName, lastName;

    @FXML
    JFXRadioButton female, male;

    @FXML
    Text danger;

    @FXML
    public void initialize() {
        int seatId = ReserveSeatChooser.chooseSeatId();
        if (seatId == -1) {
            form.setDisable(true);
        } else {
            danger.setVisible(false);
        }
    }

    @FXML
    public void menuLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.MENU.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        WindowController list = new WindowController(stage, root);


        listLink.getScene().setRoot(root);
    }

    @FXML
    public void listLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.LIST.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        WindowController list = new WindowController(stage, root);


        listLink.getScene().setRoot(root); // Root is rewritten??
    }

    @FXML
    public void seatLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.SEAT.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void reserveLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.RESERVE.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void changeLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.CHANGE.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void cancelLinkClicked() throws Exception {
        Stage stage = Main.getPrimaryStage();

        URL url = new File(FxmlPaths.CANCEL.getFxmlPath()).toURI().toURL();
        Parent root = FXMLLoader.load(url);
        WindowController list = new WindowController(stage, root);

        listLink.getScene().setRoot(root);
    }

    @FXML
    public void reserveClicked() {
        int seatId = ReserveSeatChooser.chooseSeatId();
        System.out.println("Reserving ID: " + seatId);

        int genderNumber = 0;
        if (!female.isSelected() && male.isSelected()) {
            genderNumber = 1;
        }
        if (!female.isSelected() && !male.isSelected()) {
            genderNumber = 2;
        }
        if (female.isSelected() && male.isSelected()) {
            genderNumber =  3;
        }

        SeatEditor.changeSeat(new Seat(seatId, 1, firstName.getText(), lastName.getText(), genderNumber));

        seatId = ReserveSeatChooser.chooseSeatId();

        firstName.setText("");
        lastName.setText("");
        female.setSelected(false);
        male.setSelected(false);

        if (seatId == -1) {
            form.setDisable(true);
            danger.setVisible(true);
        } else {
            danger.setVisible(false);
        }
    }
}
