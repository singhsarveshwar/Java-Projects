package assignment2.travel.testing;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.*;
import java.io.*;
import static org.junit.Assert.assertEquals;
import assignment2.travel.*;
import assignment2.travel.flying.*;
public class Testing
{
    @Test
    public void dateAndTimeContructorWithNoParameters()
    {
        DateAndTime a = new DateAndTime();
        assertEquals(2021,a.getYear());
        assertEquals(12, a.getMonth());
        assertEquals(22, a.getDay());
        assertEquals(4, a.getHour());
        assertEquals(30, a.getMinute());
    }

    @Test
    public void dateAndTimeContructorWithParameters() 
    {
        DateAndTime a = new DateAndTime(2002,05, 02, 12, 30);
        assertEquals(2002, a.getYear());
        assertEquals(05, a.getMonth());
        assertEquals(02, a.getDay());
        assertEquals(12, a.getHour());
        assertEquals(30, a.getMinute());
    }
    @Test
    public void dateAndTimeToString() 
    {
        DateAndTime a = new DateAndTime();
        assertEquals("`2021.12.22at4:30", a.toString());
    }

    @Test
    public void dateAndTimeGetTime() 
    {
        DateAndTime a = new DateAndTime();
        assertEquals("4:30", a.getTime());
    }
  /*                  TESTING OF DESTINATIONUTILS                  */
    
    @Test
    public void destinationUtilsTestDestination() {
        Destination city = DestinationUtils.getDestination("01:34");
        assertEquals(Destination.BERLIN, city);
    }

    @Test
    public void destinationUtilsTestDuration() {
        String time = DestinationUtils.getDestinationDuration(Destination.PARIS);
        assertEquals("02:20", time);
    }

    @Test
    public void destinationUtilsTestGetRoundedHours() {
        int hours = DestinationUtils.getRoundedHours(Destination.PARIS);
        assertEquals(2, hours);
    }
    /*                  TESTING OF PLANE                 */

    @Test
    public void planeEquals() 
    {
    Plane a = Plane.getInstance("Airbus",933,149);  
    Plane b = Plane.getInstance("Airbus",933,149);   
        assertTrue(a.equals(b));
    }
    @Test
    public void planeHashcode() 
    {
       Plane a = Plane.getInstance("Airbus",933,149);
        assertEquals(-624956027, a.hashCode());
    }
    @Test
    public void planeEstimatedArrivalTime() 
    {
        Plane a = Plane.getInstance("Airbus",933,149);
        int ETA = a.estimatedArrivalTime(Destination.PARIS, 15);
        assertEquals(17, ETA);
    }
    @Test
    public void planeGetprice() 
    {
       Plane a = Plane.getInstance("Airbus",933,1000);
        double p = a.getPrice(0.2);
        assertEquals(800.0, p,0.0);
    }

    /*              Testing FlightWithPlanes   */

    @Test
    public void testSave() throws IOException 
    {
    Plane a = Plane.getInstance("Boeing", 1, 100);
    Plane b = Plane.getInstance("Airbus", 2, 200);
    Plane [] arr  = {a,b};
    FlightWithManyPlanes flight = new FlightWithManyPlanes("Airbus", Destination.ROME, 80, new DateAndTime(), arr.length);
    flight.save("input.txt");
    File file = new File("input.txt");
    assertTrue(file.exists());
    }
    @Test
    public void testLoad() throws IOException 
    {
        Plane a = Plane.getInstance("Boeing", 1, 100);
        Plane b = Plane.getInstance("Airbus", 2, 200);
        Plane [] arr  = {a,b};
        FlightWithManyPlanes flight = new FlightWithManyPlanes("Airbus",Destination.ROME, 80, new DateAndTime(),arr.length);
        flight.save("input.txt");
        flight.load("input.txt");
        assertEquals("Airbus", flight.getName());
        assertEquals(Destination.ROME, flight.getDestinationCity());
        assertEquals(80, flight.getNumberOfTravellers());
        assertEquals("Airbus", flight.getName());
    }

   @Test
   public void FlightContructorWithParameters()
   {
     Flight flight = new Flight("Boeing",Destination.PARIS,20,new DateAndTime());
     assertEquals("Boeing", flight.getName());
     assertEquals(Destination.PARIS, flight.getDestinationCity());
     assertEquals(20, flight.getNumberOfTravellers());
     assertEquals("`2021.12.22at4:30", (flight.getFlightDateAndTime().toString()));
   }
    @Test
   public void FlightContructorWithNoParameters()
   {
     Flight flight = new Flight();
     assertEquals("Airbus", flight.getName());
     assertEquals(Destination.ROME, flight.getDestinationCity());
     assertEquals(83, flight.getNumberOfTravellers());
     assertEquals("`2021.12.22at4:30", flight.getFlightDateAndTime().toString());
   }
}
