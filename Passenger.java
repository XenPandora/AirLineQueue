import java.util.Random;
/** A class to represent a passenger. */ 
public class Passenger 
{
// Data Fields
/** The ID number for this passenger. */
private int passengerId;
/** The time needed to process this passenger. */ 
private int processingTime;
/** The time this passenger arrives. */
private int arrivalTime;

/** The sequence number for passengers. */ 
private static int idNum = 0;


/** Create a new passenger.
@param arrivalTime The time this passenger arrives */
    public Passenger(int arrivalTime, int maxProcessingTime) {
    	Random rand = new Random();
        this.arrivalTime = arrivalTime;
        processingTime = 1 + rand.nextInt(maxProcessingTime);
        passengerId = idNum++;
}
/** Get the arrival time. @return The arrival time */
    public int getArrivalTime() {
        return arrivalTime;
}
/** Get the processing time. @return The processing time */
    public int getProcessingTime() {
        return processingTime;
}
/** Get the passenger ID. @return The passenger ID */
    public int getId() {
        return passengerId;
}
}