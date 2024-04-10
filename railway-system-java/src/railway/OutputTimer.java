package railway;

import java.util.Timer;
import java.util.TimerTask;

public class OutputTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        int delayInSeconds = 5; // Delay in seconds

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Display seat details, user details, time details, and price here
                System.out.println("Seat details: ...");
                System.out.println("User details: ...");
                System.out.println("Time details: ...");
                System.out.println("Price: ...");
            }
        }, delayInSeconds * 1000); // Convert seconds to milliseconds

        // This is just an example; you can replace the print statements with your desired logic.
    }
}
