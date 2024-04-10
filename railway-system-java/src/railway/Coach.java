package railway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Coach {
    private static int nextCoachId = 1;
    private int coachId;
    private Train train;
    private List<Seat> seats;


    public Coach(int coachId, Train train) {

        this.coachId = coachId; // create coach number separately
        this.train = train;
        this.seats = new ArrayList<>();
        UUID coachNumber = UUID.randomUUID();
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 1; i <= 20; i++) {
            SeatType type = SeatType.LOWER;
            seats.add(new Seat(i, type, this));
        }
        for (int i = 21; i <= 40; i++) {
            SeatType type = SeatType.MIDDLE;
            seats.add(new Seat(i, type, this));
        }
        for (int i = 41; i <= 60; i++) {
            SeatType type = SeatType.UPPER;
            seats.add(new Seat(i, type, this));
        }
    }

    public int getCoachId() {
        return coachId;
    }

    public double capacity(){
        double totalSeats = seats.size();
        long occupiedSeats = totalSeatsOccupied();

        return occupiedSeats / totalSeats;
    }

    private long totalSeatsOccupied() {
        return seats.stream().filter(Seat::isBooked).count();
    }

    public boolean seatAvailable(SeatType seatTypePreference) {
        return seats.stream()
                .filter(seat -> seat.isOfType(seatTypePreference))
                .anyMatch(seat -> !seat.isBooked());

    }

    public Seat reserveSeat(User user) {
        Seat availableSeat = seats.stream()
                .filter(seat -> seat.isOfType(user.getSeatTypePreference()))
                .filter(seat -> !seat.isBooked())
                .findFirst()
                .orElseThrow();

        availableSeat.book(user);

        return availableSeat;
    }

    public boolean anySeatAvailable() {
        return seats.stream()
                .anyMatch(seat -> !seat.isBooked());
    }

    public Seat reserveAnySeat(User user) {
        Seat availableSeat = seats.stream()
                .filter(seat -> !seat.isBooked())
                .findFirst()
                .orElseThrow();

        availableSeat.book(user);

        return availableSeat;
    }

    @Override
    public String toString() {
        return """
                Coach Size: %d
                Coach Current Capacity: %f
                Seats Occupied: %d 
                """.formatted(seats.size(), capacity(), totalSeatsOccupied());
    }

    // Add other methods for managing seat allocation, pricing, and coach state
}
