package assignment2.travel.flying;
import assignment2.travel.*;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class FlightWithManyPlanes extends Flight
{
    public ArrayList <Plane> planes = new ArrayList<Plane>();
    public FlightWithManyPlanes
    (String name,Destination city,int numberOfTravellers,
    DateAndTime flightDateAndTime,int numberofPlanes)
    {
    super(name,city,numberOfTravellers,flightDateAndTime);


    Scanner sc = new Scanner(System.in);  
    for(int i = 0 ; i < numberofPlanes;i++)
        {
        System.out.println("Enter name of plane");
        String n =  sc.nextLine();
        System.out.println("Enter id");
        int id = Integer.parseInt(sc.nextLine());
           System.out.println("Ticket price");
        int ticketPrice = Integer.parseInt(sc.nextLine());

         Plane a = Plane.getInstance(n,id,ticketPrice);
         planes.add(a);
        }
    }
    public void save(String filename) throws IOException
    {
    try{
    FileWriter fw = new FileWriter(filename);
    fw.write(super.getName() +"\n");
    fw.write((super.getDestinationCity()).name()  +"\n");
    fw.write(super.getNumberOfTravellers()  +"\n");
    fw.write(super.getFlightDateAndTime().toString()  +"\n");
    for(int i = 0 ; i < planes.size();i++)
    {
        //String a  = toString();
       fw.write(((planes.get(i)).toString()  +"\n" ));
    }
    fw.close();
    }
    catch (Exception e) 
    {
        System.out.println(e);
    }
    }
    public void load (String filename) throws IOException
    {
        try{
     FileReader myfile
             = new FileReader(filename);
    BufferedReader br = new BufferedReader(myfile);
    String name = br.readLine();
    Destination destinationCity = Destination.valueOf(br.readLine());
    int numberOfTravellers = Integer.parseInt(br.readLine());
    br.readLine();
    String line = br.readLine();
    planes.clear();
    while ((line != null))
    {
        planes.add(Plane.make(line));
        line = br.readLine();
    }
    br.close();
    }
    catch (Exception e) 
    {
        System.out.println(e);
    }
    }
     public Plane getCheapestRide(double discountRateIncrease) 
     {
        if (planes.size() == 0) {
            throw new IllegalStateException("No Planes Found");
        }
        Plane cheapest = planes.get(0);
        double cheapestPrice = cheapest.getPrice(0);
        double discountRate = discountRateIncrease;
        for (int i = 1; i < planes.size(); i++) {
            Plane plane = planes.get(i);
            double price = plane.getPrice(discountRate);
            if (price < cheapestPrice) {
                cheapest = plane;
                cheapestPrice = price;
            }
            discountRate += discountRateIncrease;
        }
        return cheapest;
    }
}