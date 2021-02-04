package my_com.seat_reservation_gradle.models;

public class Seat {
    private int id;
    private int status;
    private String firstName;
    private String lastName;
    private int gender;

    public Seat(int id, int status, String firstName, String lastName, int gender) {
        this.id = id;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGender() {
        return gender;
    }
}
