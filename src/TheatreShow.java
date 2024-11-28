import java.util.ArrayList;

public class TheatreShow extends Activity {
    private ArrayList<Star> stars;


    public TheatreShow() {
        super();
        stars = new ArrayList<>();
    }

    public TheatreShow(String myName, int myCap, String myDes, double myCost, ArrayList<Passenger> participants, Destination location, ArrayList<Star> stars) {
        super(myName, myCap, myDes, myCost, participants, location);
        this.stars = stars;
    }


    //Accessors and mutators
    public ArrayList<Star> getStars() {
        return stars;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public void addStars(Star star) {
        stars.add(star);
    }
    // ————————————————————————————————————
    //Other methods
    public void printInfo() {
        super.printInfo();
        System.out.println("Stars: ");
        for (Star star: stars) {
            System.out.println("Name: " + star.getName() + ", character: " + star.getCharacter());
        }
    }
}
