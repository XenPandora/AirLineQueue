/**
 * @author - Ethan Evangelista, Nasif helped
 */
/** Simulate the check-in process of an airline. */
public class AirlineCheckinSim {
// Data Fields
/** Queue of frequent flyers. */
private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer"); 
/** Queue of regular passengers. */
private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger"); 
/** Maximum number of frequent flyers to be served
before a regular passenger gets served. */
private int frequentFlyerMax;
/** Maximum time to service a passenger. */
private int maxProcessingTime;
/** Total simulated time. */
private int totalTime;
/** If set true, print additional output. */
private boolean showAll;
/** Simulated clock. */
private int clock = 0;
/** Time that the agent will be done with the current passenger.*/ 
private int timeDone;
/** Number of frequent flyers served since the
last regular passenger was served. */ 
private int frequentFlyersSinceRP;


public void runSimulation() 
{
    for (clock = 0; clock < totalTime; clock++) 
    {
    	frequentFlyerQueue.checkNewArrival(clock, showAll);
    	regularPassengerQueue.checkNewArrival(clock, showAll);
    	if (clock >= timeDone) 
    	{
    		startServe();
    	} 
    }	
}

private void startServe() 
{
    if (!frequentFlyerQueue.isEmpty() && ((frequentFlyersSinceRP <= frequentFlyerMax)|| regularPassengerQueue.isEmpty())) 
    {
    	//Serve the next frequent flyer. frequentFlyersSinceRP++;
    	timeDone = frequentFlyerQueue.update(clock, showAll);
    } 
    else if (!regularPassengerQueue.isEmpty()) 
    {
    	//Serve the next regular passenger. frequentFlyersSinceRP = 0;
    	timeDone = regularPassengerQueue.update(clock, showAll);
    } 
    else if (showAll) 
    {
        System.out.println("Time is " + clock +" the server is idle");
    }
}

/** Method to show the statistics. */ public void showStats() {
    System.out.println
            ("\nThe number of regular passengers served was " + regularPassengerQueue.getNumServed());
    double averageRegWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();

    System.out.println(" with an average waiting time of " + averageRegWaitingTime);
    System.out.println("The number of frequent flyers served was " + frequentFlyerQueue.getNumServed());
    double averageFreWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
    System.out.println(" with an average waiting time of " + averageFreWaitingTime);
    System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.size());
    System.out.println("Passengers in regular passenger queue: " + regularPassengerQueue.size());
}

public void enterData()
{
	frequentFlyerQueue.setArrivalRate(30);
	regularPassengerQueue.setArrivalRate(30);
	frequentFlyerMax = 1;
	frequentFlyerQueue.setMaxProcessingTime(2);
	frequentFlyerQueue.setMaxProcessingTime(3);
	totalTime = 20;
	showAll = true;
}



public static void main(String args[]) 
{
    AirlineCheckinSim sim = new AirlineCheckinSim();
    sim.enterData();
    sim.runSimulation();
    sim.showStats();
    System.exit(0);
}

}




