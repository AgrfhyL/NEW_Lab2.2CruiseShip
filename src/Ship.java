import java.util.ArrayList;

public class Ship {
    private String name;
    private int capacity;
    private ArrayList<Passenger> passengers;
    private ArrayList<Destination> destinations;
    private ArrayList<Cabin> cabins;


    //constructor
    public Ship() {
        name = "Unknown ship";
        capacity = 0;
        passengers = new ArrayList<>();
        destinations = new ArrayList<>();
    }

    public Ship(String name1, int capacity1, ArrayList<Passenger> passengers1, ArrayList<Destination> destinations1) {
        name = name1;
        capacity = capacity1;
        passengers = passengers1;
        destinations = destinations1;
    }


    //accessors and mutators
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Cabin> getCabins() {
        return cabins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    //util methods
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
            return true;
        } else {
            return false;
        }
    }
    public void printItinerary() {
        System.out.println("Ship Name: " + name);
        System.out.println("Destinations: ");
        for (int i = 0; i < destinations.size(); i++) {
            Destination obj = destinations.get(i);
            System.out.println(i+1 + ". " + obj.getName());
            System.out.println("Activities: ");
            for (int j = 0; j < obj.getActivities().size(); j++) {
                obj.getActivities().get(j).printInfo();
            }
        }
    }
    public void printPassengers() {
        System.out.println("Ship Name: " + name);
        System.out.println("Passenger capacity: " + passengers.size() + " out of " + capacity + "filled");
        System.out.println("Passenger list: ");
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            passenger.printInfo(); //uses printInfo() method of Passenger class
        }
    }

    public void printAvailableActivities() {
        for (int i = 0; i < destinations.size(); i++) { //for each destination...
            ArrayList<Activity> availableActivities = destinations.get(i).returnAvailableActivities();
            if (!availableActivities.isEmpty()) { //if current destination has any available activities
                for (int j = 0; j < availableActivities.size(); j++) {
                    availableActivities.get(j).printInfo(); // for each element in arraylist, print info.
                }
            }
        }
    }

    //if follow each method call to different classes, will see modularization & class interaction
    public ArrayList<Activity> findParticipatingActivities(Passenger passenger) { //returns arraylist of activities that a passenger is enrolled in
        ArrayList<Activity> out = new ArrayList<>();
        for (int i = 0; i < destinations.size(); i++) {
            //finds and returns all Activities at one destination with passenger enrolled.
            ArrayList<Activity> actsWithPassengerAtDes = destinations.get(i).returnActivitiesWithParticipant(passenger); //refer to a Destination method
            if (!actsWithPassengerAtDes.isEmpty()) {
                out.addAll(actsWithPassengerAtDes); //adds arraylist of activities with passenger to the output arraylist
            }
        }
        return out;
    }

    public void printCabins() {
        System.out.println(name + "'s cabin allocation: ");
        for (Cabin e: cabins) {
            e.printInfo();
        }
    }
}

