package railway;

public class User {
    private SeatType seatTypePreference;
    private String name;
    private int age;
    private MealPreference mealPreference;

    public User(String name, int age, MealPreference mealPreference, SeatType seatTypePreference) {
        this.name = name;
        this.age = age;
        this.mealPreference = mealPreference;
        this.seatTypePreference = seatTypePreference;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MealPreference getMealPreference() {
        return mealPreference;
    }

    public SeatType getSeatTypePreference() {
        return seatTypePreference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMealPreference(MealPreference mealPreference) {
        this.mealPreference = mealPreference;
    }

    public void setSeatTypePreference(SeatType seatTypePreference){
        this.seatTypePreference = seatTypePreference;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mealPreference=" + mealPreference +
                ", Seat Type Preference = " + seatTypePreference +
                '}';
    }
}