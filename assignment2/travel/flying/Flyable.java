package assignment2.travel.flying;
import assignment2.travel.*;
public interface Flyable
{
   public int estimatedArrivalTime(Destination des, int departHour);
   public double getPrice(double discountRate);
}