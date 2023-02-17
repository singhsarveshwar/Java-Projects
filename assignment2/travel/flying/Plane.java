package assignment2.travel.flying;
import assignment2.travel.*;
import java.util.Objects;
public class Plane extends Flight implements Flyable
{
    public String name;
    public int id;
    public int ticketPrice;
    private static Plane p;  
    private Plane(String name, int id, int ticketPrice)
    {
        super();
        if( (name.equals(null)) && (ticketPrice < 10))
        {
            throw new IllegalArgumentException("Wrong name or Ticket price");
        }
        this.name = name;
        this.id= id;
        this.ticketPrice = ticketPrice;
    }
    public static Plane getInstance(String name,int id,int ticketPrice) 
    {      
            p = new Plane(name,id,ticketPrice);  
            return p;
    }
    public Plane makeInstance()
    {
        return p;
    }
    public String getName()
    {
        return this.name;
    }
    public int getId()
    {
        return this.id;
    }
    public int getTicketPrice()
    {
        return this.ticketPrice;
    }
    public static Plane make(String data)
    {
        String[] arr = data.split(",", 3);
        Plane a = new Plane(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
        return a;
    }
      @Override
    public boolean equals(Object obj) 
    {
        if (obj instanceof Plane) {
            Plane other = (Plane) obj;
            return getName().equals(other.getName()) && id == other.id && ticketPrice == other.ticketPrice;
        } else {
            return false;
        }
    }
     @Override
    public int hashCode()
    {
        return Objects.hash(getName(), id, ticketPrice);
    }
    @Override
    public String toString()
    {
        return this.name + Integer.toString(this.id) + Integer.toString(this.ticketPrice);
    }
    public int estimatedArrivalTime(Destination des, int departHour)
    {
        DestinationUtils b = new DestinationUtils();
        return (departHour+ b.getRoundedHours(des));
    }
    public double getPrice(double discountRate)
    {
        return ticketPrice * (1 - discountRate);
    }
}