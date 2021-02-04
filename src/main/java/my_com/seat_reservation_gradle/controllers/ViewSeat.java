package my_com.seat_reservation_gradle.controllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXNodesList;
import my_com.seat_reservation_gradle.Main;
import my_com.seat_reservation_gradle.constants.FxmlPaths;
import my_com.seat_reservation_gradle.models.Seat;
import my_com.seat_reservation_gradle.models.SeatListGetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;

public class ViewSeat {
    private List<Seat> seats;
    @FXML
    AnchorPane anchorPane;

    @FXML
    Hyperlink menuLink, listLink, seatLink, reserveLink, changeLink, cancelLink;

    @FXML
    JFXNodesList seatInfoNode;

    @FXML
    public void initialize() {
        System.out.println("heya!");

        seats = SeatListGetter.getSeatList();

        //the array below needs to be declared here
        JFXButton[] jfxButtons = {jfxButton1, jfxButton2, jfxButton3, jfxButton4, jfxButton5, jfxButton6, jfxButton7, jfxButton8, jfxButton9, jfxButton10};

        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getStatus() == 0) {
                System.out.println(i);
                jfxButtons[i].setDisable(true);
            }
        }
    }

    //ここ世界レベル
    @FXML
    JFXButton jfxButton1, jfxButton2, jfxButton3, jfxButton4, jfxButton5, jfxButton6, jfxButton7, jfxButton8, jfxButton9, jfxButton10, openNodesList;

    private String btnName = "";

    @FXML
    public void jfxButtonClicked(ActionEvent event) {
        if (seatInfoNode.isExpanded() && btnName.equals(((JFXButton) event.getSource()).getText())) {
            btnName = "";
            openNodesList.fire();
            return;
        }
        System.out.println(event.getSource());
        System.out.println(((JFXButton) event.getSource()).getText());
        System.out.println(seatInfoNode.isExpanded());

        firstName.setText(seats.get(Integer.parseInt(((JFXButton) event.getSource()).getText()) - 1).getFirstName());
        lastName.setText(seats.get(Integer.parseInt(((JFXButton) event.getSource()).getText()) - 1).getLastName());

        switch (seats.get(Integer.parseInt(((JFXButton) event.getSource()).getText()) - 1).getGender()) {
            case 0:
                female.setSelected(true);
                male.setSelected(false);
                break;
            case 2:
                female.setSelected(false);
                male.setSelected(false);
                break;
            case 1:
                female.setSelected(false);
                male.setSelected(true);
                break;
            case 3:
                female.setSelected(true);
                male.setSelected(true);
                break;
        }

        if (!seatInfoNode.isExpanded() && !btnName.equals(((JFXButton) event.getSource()).getText())) {
            openNodesList.fire();

        }
        btnName = ((JFXButton) event.getSource()).getText();



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
    JFXHamburger menuHamburger;

    @FXML
    JFXTextField firstName, lastName;
    @FXML
    JFXRadioButton female, male;
}
