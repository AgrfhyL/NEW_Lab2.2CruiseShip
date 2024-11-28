public class SeniorPassenger extends Passenger {
    private double balance;


    //constructors
    public SeniorPassenger() {
        super();
        balance = 0.0;
    }

    public SeniorPassenger(String name, int id, Ship onShip, double balance) {
        super(name, id, onShip);
        this.balance = balance;
    }


    //accessors and mutators
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    //util methods
    public void printInfo() { //overwrites superclass printInfo() method
        super.printInfo(); //call on superclass method to print name and id
        System.out.println("Balance: " + balance); //"print balance (if applicable)"
    }

    public boolean joinActivity(Activity activity) { //overwrites joinActivity() for class-specific function –> 10% discount
        if (activity.isAvailable() && balance >= activity.getCost() * 0.9) {
            activity.addParticipant(this);
            balance -= activity.getCost() * 0.9;
            return true;
        }
        return false;
    }
}
