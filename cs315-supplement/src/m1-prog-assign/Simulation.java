package edu.erau.cs315;


/**
 * Implentation of a evacuation simulator.
 *
 *  - Evacuees start in the before queue.
 *  - When a bus is ready for a new passenger, the evacuee at the front of the before queue
 *    is assigned to a bus.
 *  - When assigned to a bus, the passenger is placed pushed onto the bus.
 *  - Each passenger has a pseudorandom load time between 30 and 100 seconds.
 *  - A new passenger cannot board until the current passenger is done loading.
 *  - When a bus is full and the last passenger is fully loaded, the bus shall be unloaded and added to the after queue.
 *  - Once all done, print out the final roster of the after queue, which should show all evacuees, the order evacuated,
 *    and bus they took to the evacuation site.
 */
public class Simulation {

    private int time;

    private Bus [] buses;

    private EvacuationQueue before;
    private EvacuationQueue after;

    int numEvacuees;

    /**
     *
     * @param numBuses - number of buses in simulation
     * @param busSize - number of evacuees that can fit on a bus
     * @param numEvacuees - number of evacuees total to evacuate
     */
    public Simulation(int numBuses,
                      int busSize,
                      int numEvacuees) {

        this.time = 0;


        //Initialize Buses
        buses = new Bus[numBuses];
        for (int i=0; i < numBuses; i++) {
            //@todo initalize array of bus objects
        }

        //Initialize Queues
        //@todo initialize "before" queue to store evacuees waiting for buses
        //@todo initailize "after" queue to store evacuees once unloaded from buses

        this.numEvacuees = numEvacuees;
    }


    /**
     * Run loops until all passengers from the "before" queue are loaded onto buses and unloaded onto the
     * "after" queue.
     */
    public void run() {

        //Generate evacuees and add to the before queue
        generateEvacuees(numEvacuees);

        //Loop while (a) there are people in the before queue
        //        or (b) there are people boarding the bus that are not ready.
        while(isLoading()) {
            tick(); //Increment time counter
            updateBuses(); //Handles loading and unloading of passengers
        }
        printRoster(); //prints the list of evacuees in the order they were unloaded from the bus and placed onto the
                       // after queue

        System.out.println("Run Time" + time);
    }


    /**
     * Ticks the simulation's clock (increments time)
     */
    private void tick() {
        this.time++;
    }

    /**
     * Generates a pool of evacuees.  Each is enqueued onto the before queue.
     * @param num - number of evacquees to generate.
     */
    private void generateEvacuees(int num) {
        Evacuee evac;
        for (int i=0; i < num; i++) {
            evac = new Evacuee("Name_" + i);
            //@todo load each evacuee (evac) into the "before" queue
        }
    }


    /**
     * Implement a method to process the evacuation at each time step.
     *
     *
     * @todo implement the updateBuses method to achieve the simulation functionality
     * For each bus,
     * a) Determine if the bus is empty.  If so, load the next passenger, then continue to the next bus.
     * b) If the bus is not empty, decrement the load time counter for the evacuee at the top of the bus
     *    that is "loading onto the bus"
     * c) Once the evacuee is loaded on the bus, you must:
     *    i. If the bus is full, unload the bus adding each evacuee to the "after" queue.
     *    ii. If the before queue is empty, unload the bus adding each evacuee to the "after" queue.
     *    iii. If the bus is not full and the before queue is not empty, push the next evacuee onto the bus.
     */
    public void updateBuses()
    {
        //Local Variables
        Bus curBus;

        //Iterate through each bus
        for (int i = 0; i < buses.length; i++) {

            curBus = buses[i]; //current bus

            //@todo if current bus is empty, load a new passenger

            //@todo decrement load time for evacuee at the front of the bus
            // i.e. they are located at the top of the stack.


            /*
                @todo if the evacuee is settled on the bus (i.e. evac.isLoaded()  is true), then...
                a. If full, unload the bus.
                b. If before is empty (all evacuated), unload the bus (no more passengers)
                c. Otherwise, load another passenger.
             */
        }
    }


    /**
     * Implement - Loads the evacuee at the front of the before queue onto
     * the specified bus.
     * @param bus - bus to load next evacuee
     */
    protected void loadPassenger(Bus bus) {

        //@todo implement a method that
        // a. dequeues an evacuee from the before queue
        // b. Sets the bus id for the evacuee (i.e. which bus did they get on)
        // c. Push the evacuee on to the bus (stack)
    }

    /**
     * Implement - The loading process is in progress when
     *   a) the before queue is not empty
     *   AND
     *   b) all of the evacuees loading onto the buses are done (i.e. isLoaded())
     * @return true if loading is still in progress; false if completed.
     */
    protected boolean isLoading() {

        //@todo Implement a method that returns true if the buses are still loading
        // with passengers i.e. there are passengers in the before queue
        // OR the most recent passenger on the bus is loaded onto the bus (i.e. load
        // time remaining is zero).  False otherwise


        return false;
    }


    /**
     * Implement - Unloads a bus placing each person on the after queue
     * @param bus - bus to be unloaded.
     */
    public void unloadBus(Bus bus) {
        //@todo Implement a method that unloads each evacuee from the bus and
        // places them in the "after" queue to track the order in which they
        // arrived at the destination.
    }


    /**
     * Implement - Prints the final roster of evacuees and the buses taken
     *  from the after queue.
     */
    public void printRoster() {

        //@todo Implement a method that dequeues each evaccuee from the "after"
        // queue and prints out their information.
    }



    public static void main(String [] args) {
        Simulation s = new Simulation(2, 10, 50);
        s.run();
    }

}
