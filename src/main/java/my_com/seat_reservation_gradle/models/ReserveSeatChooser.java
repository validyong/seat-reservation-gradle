package my_com.seat_reservation_gradle.models;

import java.util.Iterator;
import java.util.List;

public class ReserveSeatChooser {
    public static int chooseSeatId() {
        List<Seat> seats = SeatListGetter.getSeatList();
        Iterator<Seat> seatsIterator = seats.iterator();

        if (seats.get(0).getStatus() == 0) {
            return 1;
        }

        if (seats.get(seats.size() - 1).getStatus() == 0) {
            return seats.size();
        }

        for (int i = 2; i < seats.size() - 2; i++) {
            if (seats.get(i - 1).getStatus() == 1) {
                continue;
            }
            if (seats.get(i).getStatus() == 1) {
                i++;
                continue;
            }
            if (seats.get(i + 1).getStatus() == 1) {
                i += 2;
                continue;
            }
            return i + 1;
        }

        int seatId = 1;
        while (seatsIterator.hasNext()) {
            if (seatsIterator.next().getStatus() == 0) {
                return seatId;
            }
            seatId++;
        }

        return -1;
    }
}
