public class Cabin {
    private String cabinName;
    private Passenger passenger;

    public Cabin(){
        cabinName = "Unknown cabin";
        passenger = null;
    }

    public Cabin (String name, Passenger passenger1) {
        cabinName = name;
        passenger = passenger1;
    }

    public void setCabinName(String name) {
        cabinName = name;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void printInfo() {
        System.out.println(cabinName);
        if (!cabinIsEmpty()) {
            System.out.println("Passenger in cabin: ");
            passenger.printInfo();
        } else {
            System.out.println("Cabin is unoccupied");
        }
    }
    public boolean isAvailable(Passenger passenger) {
        return cabinIsEmpty();
    }

    public boolean cabinIsEmpty() {
        return passenger == null;
    }

}
