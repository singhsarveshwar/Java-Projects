package assignment2.travel.flying;
import assignment2.travel.*;
public class Flight
{
    protected String name;
    protected Destination destinationCity;
    protected int numberOfTravellers;
    protected DateAndTime flightDateAndTime;

    public Flight(String name,Destination city,int numberOfTravellers,DateAndTime flightDateAndTime)
    {
        this.name =name;
        this.destinationCity = city;
        this.numberOfTravellers = numberOfTravellers;
        if( (numberOfTravellers < 15) && (numberOfTravellers > 100))
        {
            throw new IllegalArgumentException("not correct number of passengers");
        }
        
        this.flightDateAndTime = flightDateAndTime;
    }
    public Flight()
    {
        // DateAndTime a1 = ;
        this("Airbus",Destination.ROME,83,new DateAndTime());
      //  Flight a = new Flight("Airbus",Destination.ROME,83,a1);
    }
    public String getName()
    {
        return this.name;
    }
    public Destination getDestinationCity()
    {
        return this.destinationCity;
    }
    public int getNumberOfTravellers()
    {
        return this.numberOfTravellers;
    }
    public DateAndTime getFlightDateAndTime()
    {
        return this.flightDateAndTime;
    }
    public String getFlightDuration()
    {
        DestinationUtils a = new DestinationUtils();
        return a.getDestinationDuration(destinationCity);
    }
     @Override
     public String toString()
     {
        return "Flying "+ this.name + "with " +Integer.toString(numberOfTravellers) + 
        " passengers to " + this.destinationCity +" "+ (this.flightDateAndTime).toString();
     }


}