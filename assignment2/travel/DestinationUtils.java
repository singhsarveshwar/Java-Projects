package assignment2.travel;
// import travel.flying;
public class DestinationUtils
{
    static Destination a;
    static String name;
    public static Destination getDestination(String str)
    {
        
        String cities[] = {"BERLIN","ROME","AMSTERDAM","PARIS","HELSINKI"};
        for(int i=0;i<cities.length;i++)
        {
            if( str.compareTo((Destination.valueOf(cities[i])).getLabel()) == 0)
           { 
            a= Destination.valueOf(cities[i]);
            break;
           }
            else
            {
                 a= null;
            }
           
        }
        return a;
    }
    public static String getDestinationDuration(Destination city)
    {
        String cities[] = {"BERLIN","ROME","AMSTERDAM","PARIS","HELSINKI"};
        for(int i=0;i<cities.length;i++)
        {
            if( (city.name()).compareTo((cities[i])) == 0)
           { 
            name = (Destination.valueOf(cities[i])).getLabel();
           }
           
        }
        return name;
    }
    public static int getRoundedHours(Destination city)
    {
        String hour = "";
        String min = "";
         DestinationUtils des = new DestinationUtils();
         String name = des.getDestinationDuration(city);
         String[] arr = name.split(":", 2);
            hour = arr[0];
            min = arr[1];
        if(Integer.parseInt(min) >= 30)
        return (Integer.parseInt(hour) + 1);
        else
        return Integer.parseInt(hour) ;
    }
}