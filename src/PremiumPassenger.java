public class PremiumPassenger extends Passenger {

    //constructors
    public PremiumPassenger() {
        super();
    }

    public PremiumPassenger(String name, int id, Ship onShip) {
        super(name, id, onShip);
    }


    //inherits the printInfo() method from parent class
    //inherits joinActivity() method from parent class, no need to overwrite
}
