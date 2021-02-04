package my_com.seat_reservation_gradle.models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObservableSeat extends RecursiveTreeObject<ObservableSeat> {
    SimpleIntegerProperty id, status, gender;
    StringProperty firstName, lastName;

    public ObservableSeat(Seat seat) {
        id = new SimpleIntegerProperty(seat.getId());
        status = new SimpleIntegerProperty(seat.getStatus());
        firstName = new SimpleStringProperty(seat.getFirstName());
        lastName = new SimpleStringProperty(seat.getLastName());
        gender = new SimpleIntegerProperty(seat.getGender());
    }

    public SimpleIntegerProperty getId() {
        return id;
    }

    public SimpleIntegerProperty getStatus() {
        return status;
    }

    public StringProperty getFirstName() {
        return firstName;
    }

    public StringProperty getLastName() {
        return lastName;
    }

    public SimpleIntegerProperty getGender() {
        return gender;
    }
}
