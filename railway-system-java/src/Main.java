import railway.*;

import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        TicketBooth ticketBooth = TicketBooth.getBookingInstance();
        TrainSystem trainSystem = TrainSystem.getInstance(ticketBooth);

        Scanner scanner = new Scanner(System.in);

        // Create a train and coaches
        Train trainA = trainSystem.createTrain("Route A", 10);
        Train trainB = trainSystem.createTrain("Route B", 10);

        int userInput = 0;
        do {
            System.out.println("""
        1. User 
        2. Admin
        """);
            int firstInput = scanner.nextInt();

            if (firstInput == 1) {
                User newUser = new User();
                var trains = trainSystem.getAllTrains();
                System.out.printf("""
                    Which train?
                    %s
                    %n""", trains);
                int trainId = scanner.nextInt();

                Train selectedTrain = trainSystem.getTrainById(trainId);

                // take user preference
                System.out.println("Enter Your Name: ");
                newUser.setName(scanner.next());
                System.out.println("Enter Your Age: ");
                newUser.setAge(scanner.nextInt());
                System.out.println("Enter Your Meal Preference - 1. Veg 2. NonVeg (Select a Number)");
                Integer mealPreferenceOption = scanner.nextInt();
                if (mealPreferenceOption.equals(1)) {
                    newUser.setMealPreference(MealPreference.VEG);
                } else {
                    newUser.setMealPreference(MealPreference.NON_VEG);
                }

                System.out.println("Enter Your Seat Preference - 1. Lower 2. Middle 3.Upper (Select a Number)");
                Integer seatPreferenceOption = scanner.nextInt();
                if (seatPreferenceOption.equals(1)) {
                    newUser.setSeatTypePreference(SeatType.LOWER);
                } else if (seatPreferenceOption.equals(2)) {
                    newUser.setSeatTypePreference(SeatType.MIDDLE);
                } else {
                    newUser.setSeatTypePreference(SeatType.UPPER);
                }

                // Book a seat
                BookingInfo bookingInfo = trainSystem.bookSeat(newUser, selectedTrain);

                // Display seat details, user details, time details, and price after a delay
                int delayInSeconds = 5; // Delay in seconds
                Thread.sleep(delayInSeconds * 1000);
                // Display details
                System.out.println("Seat details: " + bookingInfo.seat().getSeatNumber() + " in Coach " + bookingInfo.seat().getCoach().getCoachId());
                System.out.println("Seat Type: " + bookingInfo.seat().getSeatType());
                System.out.println("User details: " + newUser.getName() + " (Age: " + newUser.getAge() + ")");
                System.out.println("Time details: " + bookingInfo.bookedAt());
                System.out.println("Price: " + bookingInfo.ticketPrice() + " Rs");
            } else {
                System.out.println("Select which train you want to view: 1-10");
                List<Train> allTrains = TrainSystem.getInstance(ticketBooth).getAllTrains();
                System.out.println(allTrains.stream().map((Train::getTrainId)).toList());
                System.out.println("Enter the id of train: ");
                int adminTrainSelectOption = scanner.nextInt();
                Train selectedTrain = TrainSystem.getInstance(ticketBooth).getTrainById(adminTrainSelectOption);
                System.out.println("Select which coach you want to view: 1-10");
                int adminCoachSelectOption = scanner.nextInt();
                System.out.println(selectedTrain.getCoachById(adminCoachSelectOption));
            }

            System.out.println("Do you wish to exit? 1=yes, 2=no");
            userInput = scanner.nextInt();
        } while (userInput != 1);

    }

}
