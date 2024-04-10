package railway;

import java.util.ArrayList;
import java.util.List;

public class TrainSystem {
    private static TrainSystem instance;
    private final ArrayList<Train> trains;
    private final TicketBooth ticketBooth;


    private TrainSystem(TicketBooth ticketBooth) { /* Constructor logic */
        this.trains = new ArrayList<>();
        this.ticketBooth = ticketBooth;
    }



    public static TrainSystem getInstance(TicketBooth ticketBooth) {
        if (instance == null) {
            instance = new TrainSystem(ticketBooth);
        }
        return instance;
    }

    public Train createTrain(String route, int numCoaches) {
        Train train = new Train(route, numCoaches);
        trains.add(train);
        return train;
    }

    public Train getTrainById(int trainId) {
        for (Train train : trains) {
            if (train.getTrainId() == trainId) {
                return train;
            }
        }
        return null;
    }

    public List<Train> getAllTrains() {
        return trains;
    }

    public BookingInfo bookSeat(User user, Train selectedTrain){
        Seat bookedSeat = ticketBooth.bookSeat(user, selectedTrain);
        double ticketPrice = ticketBooth.calculatePrice(bookedSeat);

        return BookingInfo.newInstance(selectedTrain, bookedSeat, ticketPrice);
    }
}
