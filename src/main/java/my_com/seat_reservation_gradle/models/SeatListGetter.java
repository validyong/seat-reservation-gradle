package my_com.seat_reservation_gradle.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatListGetter {
    public static List<Seat> getSeatList() {
        String sql = "SELECT * FROM seat";
        List<Seat> seats = new ArrayList<>();

        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cn = DB.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                seats.add(new Seat(
                        rs.getInt("id"),
                        rs.getInt("status"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("gender")

                ));
            }


        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DB.close(cn);
            DB.close(ps);
            DB.close(rs);
        }

        return seats;
    }

}
