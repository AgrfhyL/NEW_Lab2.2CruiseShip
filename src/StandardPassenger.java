public class StandardPassenger extends Passenger {
    private double balance;


    //constructors
    public StandardPassenger() {
        super();
        balance = 0.0;
    }

    public StandardPassenger(String name, int id, Ship onShip, double balance) {
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
    public void printInfo() {//for detailed comments, see SeniorPassenger
        super.printInfo();
        System.out.println("Balance: " + balance);
    }

    public boolean joinActivity(Activity activity) { //overwrites superclass method for specific function: balance check & operation
        if (activity.isAvailable() && balance >= activity.getCost()) {
            activity.addParticipant(this);
            balance = balance - activity.getCost();
            return true;
        }
        return false;
    }
}
