import java.util.ArrayList;

public class WalkingTour extends Activity {
    private double distanceToWalk;


    //constructors
    public WalkingTour() {
        super();
        distanceToWalk = 0.0;
    }

    public WalkingTour(String myName, int myCap, String myDes, double myCost, ArrayList<Passenger> participants, Destination location, double distance) {
        super(myName, myCap, myDes, myCost, participants, location);
        distanceToWalk = distance;
    }


    //accessors and mutators
    public double getDistanceToWalk() {
        return distanceToWalk;
    }

    public void setDistanceToWalk(double distanceToWalk) {
        this.distanceToWalk = distanceToWalk;
    }

    //util method
    public void printInfo() {
        super.printInfo();
        System.out.println("Distance to walk: " + distanceToWalk);
    }
}
