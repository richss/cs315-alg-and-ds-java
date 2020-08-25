import java.util.Random;

/**
 * Implements a simple class to represent evacuees
 */

public class Evacuee {

    //Parameters for random wait time.
    public static final int MIN_LOAD_TIME = 30;
    public static final int MAX_LOAD_TIME = 100;
    Random rand;

    //Attributes of evacuee
    String name;
    int busNo;
    int loadingTimeRemaining;


    /**
     * Default constructor
     * @param name - name of evacuee
     */
    public Evacuee(String name) {
        this.rand = new Random();
        this.name = name;
        this.busNo = -1;
        this.loadingTimeRemaining = getLoadingTime();
    }


    /**
     * @return random number between MIN_LOAD_TIME and MAX_LOAD_TIME
     */
    private int getLoadingTime() {
        return MIN_LOAD_TIME + Math.abs(rand.nextInt())%(MAX_LOAD_TIME-MIN_LOAD_TIME);
    }


    /**
     * Decrements the time remaining for evacuee to be fully loaded.
     * @return
     */
    public void decrementLoadingTime() {
        --loadingTimeRemaining;
    }

    /**
     *
     * @return true if the evacuee has no wait remaining.
     */
    public boolean isLoaded() {
        return (loadingTimeRemaining == 0);
    }

    /**
     * Sets the bus that the evacuee is assigned
     * @param busNo - assigned bus
     */
    public void setBus(int busNo) {
        this.busNo = busNo;
    }

    /**
     *
     * @return string representation of evacuee.
     */
    public String toString() {
        return name + ", " + busNo;
    }
}
