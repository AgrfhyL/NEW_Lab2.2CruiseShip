import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Init Setup ——————————————————————————————————————————————————————————————————————————
        Ship ship1 = new Ship();
        Destination CSDep = new Destination();
        Destination mathDep = new Destination();
        Destination dramaDep = new Destination();
        WalkingTour walk512 = new WalkingTour();
        TheatreShow rasputin = new TheatreShow();
        WalkingTour walkAAHL = new WalkingTour();
        AttractionVisit AEDotaGame = new AttractionVisit();
        ArrayList<Destination> destinations = new ArrayList<>();
        ArrayList<Activity> mathDepActivities = new ArrayList<>();
        ArrayList<Activity> CSDepActivities = new ArrayList<>();
        ArrayList<Activity> dramaDepActivities = new ArrayList<>();
        ArrayList<Passenger> walk512Part = new ArrayList<>();
        ArrayList<Passenger> rasputinPart = new ArrayList<>();
        ArrayList<Passenger> walkAAHLPart = new ArrayList<>();
        ArrayList<Passenger> AEDotaGamePart = new ArrayList<>();
        ArrayList<Cabin> cabins = new ArrayList<>();

        CSDepActivities.add(walk512);
        CSDepActivities.add(AEDotaGame);
        mathDepActivities.add(walkAAHL);
        dramaDepActivities.add(rasputin);

        CSDep.setActivities(CSDepActivities);
        dramaDep.setActivities(dramaDepActivities);
        mathDep.setActivities(mathDepActivities);
        CSDep.setName("CS Department");
        dramaDep.setName("Drama Department");
        mathDep.setName("Math Department");

        destinations.add(CSDep);
        destinations.add(dramaDep);
        destinations.add(mathDep);

        //passenger setup
        PremiumPassenger Ewing = new PremiumPassenger("Adam Ewing", 1, ship1);
        PremiumPassenger Nahar = new PremiumPassenger("Nitu Nahar", 2, ship1);
        StandardPassenger Liang = new StandardPassenger("Andy Liang", 3, ship1, 5.4);
        StandardPassenger Chen = new StandardPassenger("Justin Chen", 4, ship1, 40.0);
        SeniorPassenger Hayes = new SeniorPassenger("Mark Hayes", 5, ship1,713.1);

        walk512Part.add(Nahar);
        walk512Part.add(Hayes);
        AEDotaGamePart.add(Ewing);
        walkAAHLPart.add(Liang);

        //walk512 setup –>
        String tour512Description = "You will walk around and explore the mythical treasure room: 512 of CIS.";
        walk512.setName("Walk 512");
        walk512.setCapacity(50);
        walk512.setCost(31.0);
        walk512.setDistanceToWalk(200.0);
        walk512.setDescription(tour512Description);
        walk512.setParticipants(walk512Part);
        walk512.setLocation(CSDep);
        walk512Part.add(Nahar);
        walk512Part.add(Ewing);
        walk512Part.add(Hayes);
        walk512Part.add(Liang);


        //AEDotaGame setup –> 4 SPOT LEFT
        AEDotaGame.setName("Mr. Ewing's Dota Game");
        AEDotaGame.setCapacity(5);
        AEDotaGame.setCost(716.0);
        AEDotaGame.setDescription("Mr. Ewing is addicted to Dota 2. He's hosting a match and is charging people for watching his gameplay.");
        AEDotaGame.setParticipants(AEDotaGamePart);
        AEDotaGame.setLocation(CSDep);

        //walkAAHL setup –> ONE SPOT LEFT
        walkAAHL.setName("Walk AAHL");
        walkAAHL.setCapacity(30);
        walkAAHL.setCost(0.0);
        walkAAHL.setDescription("Explore the depths of mathematics.");
        walkAAHL.setParticipants(walkAAHLPart);
        walkAAHL.setParticipants(genRandomPassengers(28, ship1));
        walkAAHL.setLocation(mathDep);
        walkAAHL.setDistanceToWalk(3.1415);

        //rasputin setup –> FULL ACTIVITY
        Star actor1 = new Star("JY", "Ermakov");
        Star actor2 = new Star("Carissa", "Rasputin");
        ArrayList<Star> stars = new ArrayList<>();
        stars.add(actor1);
        stars.add(actor2);
        rasputin.setStars(stars);
        rasputin.setCapacity(10);
        rasputin.setName("Rasputin: An original student play");
        rasputin.setDescription("This play is completely original with almost all aspects produced by CIS students.");
        rasputin.setCost(39.99);
        rasputin.setParticipants(genRandomPassengers(10, ship1));
        rasputin.setLocation(dramaDep);

        //cabins setup
        Cabin One = new Cabin("Cabin 001", Chen);
        Cabin Two = new Cabin("Cabin 002", null);
        Cabin Three = new Cabin("Cabin 003", null);
        PremiumCabin Four = new PremiumCabin("Cabin 004", null);
        cabins.add(One);
        cabins.add(Two);
        cabins.add(Three);
        cabins.add(Four);

        ship1.setName("Titanic");
        ship1.setCapacity(100);
        ship1.setDestinations(destinations);
        ship1.setPassengers(genRandomPassengers(95, ship1));
        ship1.setCabins(cabins);
        ship1.addPassenger(Liang);
        ship1.addPassenger(Chen);
        ship1.addPassenger(Hayes);
        ship1.addPassenger(Nahar);
        ship1.addPassenger(Ewing);

        //Scenario 1 ——————————————————————————————————————————————————————————————————————————
        System.out.println("You will be guided through 4 scenarios demonstrating the functionality of this cruise ship system. You can press enter to continue to the next step / line of output.");
        pressEnter();
        System.out.println("Scenario 1: Balance System");
        pressEnter();
        Chen.printInfo();
        pressEnter();
        System.out.println("Justin joining Mr. Ewing's Dota Game: ");
        pressEnter();
        Chen.joinActivity(AEDotaGame);
        System.out.println();
        AEDotaGame.printInfo();
        System.out.println("Justin Chen can't join this activity because he doesn't have enough balance.");
        pressEnter();
        System.out.println("Justin joining rasputin: ");
        pressEnter();
        Chen.joinActivity(rasputin);
        System.out.println();
        rasputin.printInfo();
        System.out.println("Justin Chen can't join this activity because it is full.");
        pressEnter();
        System.out.println("Justin joining Walk 512: ");
        pressEnter();
        Chen.joinActivity(walk512);
        walk512.printInfo();
        System.out.println("Justin Chen joined this activity because he had enough balance");
        pressEnter();

        System.out.println("Justin's current info (specifically look at his balance change): ");
        pressEnter();
        Chen.printInfo();
        pressEnter();

        //Scenario 2 ——————————————————————————————————————————————————————————————————————————
        System.out.println("Scenario 2: Full ship searches");
        pressEnter();
        System.out.println("Andy Liang wants to find available activities.");
        pressEnter();
        ship1.printAvailableActivities();
        pressEnter();

        System.out.println("How about info on the entire ship?");
        pressEnter();
        ship1.printItinerary();
        pressEnter();

        //Scenario 3 ——————————————————————————————————————————————————————————————————————————
        System.out.println("Scenario 3: Passenger types");
        pressEnter();
        System.out.println("Mr. Hayes wants to join Mr. Ewing's Dota game. Is he able to join?");
        pressEnter();
        System.out.println("Game info: ");
        AEDotaGame.printInfo();
        pressEnter();
        System.out.println("Mr. Hayes' info: ");
        pressEnter();
        Hayes.printInfo();
        System.out.println("Press enter to let Mr. Hayes attempt to join Mr. Ewing's game");
        pressEnter();
        System.out.println("Mr Hayes joined activity = " + Hayes.joinActivity(AEDotaGame));
        pressEnter();
        Hayes.printInfo();
        System.out.println("He is a senior passenger, thus gets 10% discount when entering activities");
        pressEnter();
        System.out.println("Andy wants to join Mr. Ewing's game too!");
        pressEnter();
        System.out.println("Andy joined activity = " + Liang.joinActivity(AEDotaGame));
        pressEnter();
        Liang.printInfo();
        System.out.println("He doesn't have enough balance");

        pressEnter();
        System.out.println("Now Ms. Nahar wants the join as well");
        pressEnter();
        System.out.println("Ms. Nahar joined activity = " + Nahar.joinActivity(AEDotaGame));
        pressEnter();
        Nahar.printInfo();
        System.out.println("She's a premium passenger, so she can join any activity free of charge!");

        //Scenario 4 ——————————————————————————————————————————————————————————————————————————
        System.out.println("Scenario 4: Cabin system");
        pressEnter();
        System.out.println("The ship has these cabins: (Ship printCabin() method)");
        ship1.printCabins();
        pressEnter();
        System.out.println("Now Andy wants to book a regular cabin, Cabin 002. The bookCabin() method will be called");
        Liang.bookCabin(Two);
        System.out.println("He successfully booked cabin 002 as it was originally unoccupied and Cabin 002 is a regular cabin. As a standard passenger, Andy should be able to book a regular cabin.");
        pressEnter();
        System.out.println("Now Ms. Nahar, a premium passenger also wants to book a standard cabin, she should be able to do this: ");
        Nahar.bookCabin(Three);
        System.out.println("She's also able to book this as premium passengers can book regular cabins");
        pressEnter();
        System.out.println("Premium and Senior passengers can both book premium cabins. But there's only 1 available premium cabin.");
        pressEnter();
        System.out.println("Is Mr. Hayes (senior passenger) or Mr. Ewing (premium passenger) going to get the cabin? First come first serve!");
        pressEnter();
        Hayes.bookCabin(Four);
        System.out.println("Now we can look at the information on cabins by using the ship's printCabin() method again: ");
        pressEnter();
        ship1.printCabins();
    }



    public static ArrayList<Passenger> genRandomPassengers(int count, Ship ship) {
        ArrayList<Passenger> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randID = (int) (100000 * Math.random()) + 1;
            String name = "Pass" + i+1;
            Passenger pass = new Passenger(name, randID, ship);
            out.add(pass);
        }
        return out;
    }

    public static void pressEnter() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
