package my_com.seat_reservation_gradle.controllers;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import my_com.seat_reservation_gradle.Main;
import my_com.seat_reservation_gradle.constants.FxmlPaths;
import my_com.seat_reservation_gradle.models.ObservableSeat;
import my_com.seat_reservation_gradle.models.Seat;
import my_com.seat_reservation_gradle.models.SeatListGetter;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.function.Function;

public class ViewList {

    @FXML
    JFXTreeTableView<ObservableSeat> table;
    @FXML
    JFXTreeTableColumn<ObservableSeat, Integer> idColumn, statusColumn, genderColumn;
    @FXML
    JFXTreeTableColumn<ObservableSeat, String> firstNameColumn, lastNameColumn;
    private ObservableList<ObservableSeat> obsSeats = FXCollections.observableArrayList();

    @FXML
    Hyperlink menuLink, listLink, seatLink, reserveLink, changeLink, cancelLink;

    public ViewList() {
        System.out.println("List");
    }

    @FXML
    public void initialize() {
        List<Seat> seats = SeatListGetter.getSeatList();
        for (Seat seat : seats) {
            obsSeats.add(new ObservableSeat(seat));
        }

        setTable();
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

    private <T> void setupCellValueFactory(JFXTreeTableColumn<ObservableSeat, T> column, Function<ObservableSeat, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<ObservableSeat, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private void setTable() {
        setupCellValueFactory(idColumn, p -> p.getId().asObject());
        setupCellValueFactory(statusColumn, p -> p.getStatus().asObject());
        setupCellValueFactory(firstNameColumn, ObservableSeat::getFirstName);
        setupCellValueFactory(lastNameColumn, ObservableSeat::getLastName);
        setupCellValueFactory(genderColumn, p -> p.getGender().asObject());

        table.setRoot(new RecursiveTreeItem<>(obsSeats, RecursiveTreeObject::getChildren));
        table.setShowRoot(false);

    }


}
