public class PremiumCabin extends Cabin {


    public PremiumCabin(){
        super();
    }

    public PremiumCabin(String name, Passenger passenger) {
        super(name, passenger);
    }

    public boolean isAvailable(Passenger passengerTryingToJoin) {
        String theClass = passengerTryingToJoin.getClass().getSimpleName();
        return cabinIsEmpty() && (theClass.equals("PremiumPassenger") || theClass.equals("SeniorPassenger"));
    }
}
