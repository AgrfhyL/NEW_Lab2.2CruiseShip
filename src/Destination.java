import java.util.ArrayList;

public class Destination {
    private String name;
    private ArrayList<Activity> activities;


    //constructors
    public Destination() { //explicitly write no-arg constructor, good coding practice
        name = "Unknown destination";
        activities = new ArrayList<>();
    }

    public Destination(String name, ArrayList<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    //accessors and mutators
    public String getName() {
        return name;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }


    //find all available activities at this destination
    public ArrayList<Activity> returnAvailableActivities() {
        ArrayList<Activity> out = new ArrayList<>();
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).isAvailable()) {
                out.add(activities.get(i));
            }
        }
        return out;
    }

    //search this destination for activities with a specific passenger enrolled, return them in arraylist
    public ArrayList<Activity> returnActivitiesWithParticipant(Passenger passenger) {
        ArrayList<Activity> out = new ArrayList<>();
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).hasPassenger(passenger)) {//modularization of problem: hasPassenger() in activity class
                out.add(activities.get(i));
            }
        }
        return out;
    }
}
