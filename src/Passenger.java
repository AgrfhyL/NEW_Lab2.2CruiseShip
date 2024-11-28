import java.util.ArrayList;

public class Passenger {
    private String name;
    private int id;
    private Ship onShip; //annoying, added this field for 1 specific function (printInfo())
    //but Passengers have compositional relationship with Ship anyway, so "dependency" doesn't matter too much.


    //constructors
    public Passenger() {
        name = "Unknown passenger";
        id = -1;
        onShip = new Ship();
    }

    public Passenger(String name, int id, Ship onShip) {
        this.name = name;
        this.id = id;
        this.onShip = onShip;
    }


    //accessors and mutators
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }


    //util methods
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Signed up for the following activities: ");
        //calls on Ship method() to find search for all activities with participant enrolled
        //because ship has all Destination (and therefore activity) info.
        ArrayList<Activity> activityList = onShip.findParticipatingActivities(this);
        for (int i = 0; i < activityList.size(); i++) {
            System.out.println("At location: " + activityList.get(i).getLocation().getName());
            activityList.get(i).printInfo();
        }
    }

    public boolean joinActivity(Activity activity) {
        if (activity.isAvailable()) {
            activity.addParticipant(this);
            return true;
        }
        return false; //returns crucial info for if I further develop the program.
    }

    public boolean bookCabin(Cabin cabin) {
        if (cabin.isAvailable(this)) {
            cabin.setPassenger(this);
            System.out.println("You've booked the cabin!");
            return true;
        } else {
            System.out.println("This cabin is already full! Try picking another cabin.");
            return false;
        }
    }
}
