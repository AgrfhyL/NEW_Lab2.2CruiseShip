import java.util.ArrayList;

public class AttractionVisit extends Activity {
    //no additional fields needed, but I need to differentiate from walking tours and theatre.


    //constructors
    public AttractionVisit() {
        super(); //code reuse (constructor);
    }

    public AttractionVisit(String myName, int myCap, String myDes, double myCost, ArrayList<Passenger> participants, Destination location) {
        super(myName, myCap, myDes, myCost, participants, location);
    }
}
