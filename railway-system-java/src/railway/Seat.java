package railway;

public class Seat {
    private int seatNumber;
    private SeatType seatType;
    private Coach coach;
    private User user;

    public Seat(int seatNumber, SeatType seatType, Coach coach) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.coach = coach;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Coach getCoach() {
        return coach;
    }

    public User getUser() {
        return user;
    }

    public boolean isBooked() {
        return user != null;
    }

    public void book(User user) {
        this.user = user;
    }

    public void cancelBooking() {
        if (isBooked()) {
            this.user = null;
            // You can implement any necessary logic for canceling the booking here
        } else {
            throw new RuntimeException("Seat " + seatNumber + " is not booked.");
        }
    }

    public boolean isOfType(SeatType seatTypePreference) {
        return this.seatType == seatTypePreference;
    }
}
