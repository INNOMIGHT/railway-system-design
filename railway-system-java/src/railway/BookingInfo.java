package railway;

import java.time.LocalDateTime;

public record BookingInfo(Train train, Seat seat, double ticketPrice, LocalDateTime bookedAt){
    public static BookingInfo newInstance(Train train, Seat seat, double ticketPrice) {
        return new BookingInfo(train, seat, ticketPrice, LocalDateTime.now());
    }
}
