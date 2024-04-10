package railway;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private static int nextTrainId = 1;
    private final int trainId;
    private final String route;
    private final List<Coach> coaches;

    public Train(String route, int numCoaches) {
        this.trainId = nextTrainId++;
        this.route = route;
        this.coaches = createCoaches(numCoaches);
    }

    public int getTrainId() {
        return trainId;
    }

    public String getRoute() {
        return route;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public Coach getCoachById(int coachId) {
        return this.getCoaches().stream().filter((coach -> coach.getCoachId() == coachId)).findFirst().orElseThrow();
    }

    private List<Coach> createCoaches(int numCoaches) {
        var coaches = new ArrayList<Coach>();
        for (int i = 0; i < numCoaches; i++) {
            coaches.add(new Coach(i + 1, this));
        }

        return coaches;
    }

    // Add other methods for managing coaches and the train's state
}
