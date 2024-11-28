import java.util.ArrayList;

public class Activity {
    private String name;
    private int capacity;
    private String description;
    private double cost;
    private ArrayList<Passenger> participants;
    private Destination location; //this field added because task specified the need to print location of activity
    // i wanted to simplify the algorithm, avoiding the use of 1 extra loop, used in Passenger's printInfo(), so
    // i add location as an attribute. but then makes Activity composition of Destination.
    //THINK FURTHER, NOT NECCESSARILY BAD, CUZ EVEN IF REMOVE, WHEN WANT TO FIND WHERE AN ACTIVITY IS, STILL HAVE TO USE DESTINATION


    //constructors
    public Activity() {
        name = "Unnamed Activity";
        capacity = 0;
        description = "No description";
        cost = 0.0;
        participants = new ArrayList<>();
    }

    public Activity(String myName, int myCap, String myDes, double myCost, ArrayList<Passenger> participants, Destination location) {
        name = myName;
        capacity = myCap;
        description = myDes;
        cost = myCost;
        this.participants = participants;
        this.location = location;
    }


    //Accessors and mutators
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Passenger> getParticipants() {
        return participants;
    }

    public Destination getLocation() {
        return location;
    }

    public void setLocation(Destination location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipants(ArrayList<Passenger> participants) {
        this.participants = participants;
    }


    // below are simple methods that modularize tasks
    public void printInfo() {
        int avail = capacity - participants.size();
        System.out.println(name + "($" + cost + "): " + avail + "/" + capacity + " spots left.");
    }

    public boolean isAvailable() {
        return participants.size() < capacity;
    }

    public boolean hasPassenger(Passenger passenger) {
        return participants.contains(passenger);
    }

    public void addParticipant(Passenger passenger) {
        participants.add(passenger);
    }

}
