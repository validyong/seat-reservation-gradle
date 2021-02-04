package my_com.seat_reservation_gradle.constants;

public enum FxmlPaths {
    MENU("src/main/resources/fxml/menu.fxml"),
    LIST("src/main/resources/fxml/view-list.fxml"),
    SEAT("src/main/resources/fxml/view-seat.fxml"),
    RESERVE("src/main/resources/fxml/reservation.fxml"),
    CHANGE("src/main/resources/fxml/change-seat.fxml"),
    CANCEL("src/main/resources/fxml/cancel-seat.fxml")
    ;

    private final String fxmlPath;

    FxmlPaths(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public String getFxmlPath() {
        return this.fxmlPath;
    }
}


