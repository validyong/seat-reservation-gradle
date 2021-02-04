package my_com.seat_reservation_gradle.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeatEditor {
    public static void changeSeat(Seat seat) {

        String sql = "UPDATE SEAT SET STATUS = ?, FIRST_NAME = ?, LAST_NAME = ?, GENDER = ? WHERE ID = ?";

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = DB.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, seat.getStatus());
            ps.setString(2, seat.getFirstName());
            ps.setString(3, seat.getLastName());
            ps.setInt(4, seat.getGender());
            ps.setInt(5, seat.getId());

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DB.close(cn);
            DB.close(ps);
        }
    }
}
