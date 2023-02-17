package observation;
import java.util.*;
import java.io.*;
import java.lang.IllegalArgumentException;
import celestialbodies.*;
public class StarExplorer
{
    private StarSystem startSystem;
    public StarExplorer( String filename)
    {
   
    BufferedReader br = new BufferedReader(new FileReader(fileName));
StarSystem x = new StarSystem();
    String str=reader.readLine();
    String [] arr = str.split(" ");//PizzaStatusEnum.valueOf("READY")
    Star a = new Star ( arr[0],Double.parseDouble(arr[1]),Integer.parseInt(arr[2]),CelestialBodyType.valueOf(arr[3]),Integer.parseInt(arr[2]) );
    x.star = a;
    while(Line != null)
    {
        
        str=reader.readLine();
        String [] arr1 = str.split(" ");
        Planet p = new Planet(arr[0],Double.parseDouble(arr[1]),Integer.parseInt(arr[2]),CelestialBodyType.valueOf(arr[3]),
        WorldType.valueOf(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]),Integer.parseInt(arr[7]));
        x.planets.add(p);
        str=reader.readLine();
    }
    }
    public static Boolean isHabitable(Planet pl)
    {
        if((pl.bodyType == CelestialBodyType.TERRESTRIAL_PLANET)
        && (pl.worldType == WorldType.CONTINENTAL || pl.worldType == WorldType.OCEAN pl.worldType == WorldType.LANDMASS )
          && (pl.nitrogen > 70 && pl.nitrogen < 80)
          && (pl.oxygen >20 && pl.oxygen <25)
          && (p1.OtherElements < 5) )
          return true;
          else
          return false;
    }
     
    public Boolean isHabitable(String name)
    {
        Boolean a = false;
        Planet a1 = new Planet();
        for(int i = 0 ; i < x.p.size();i++)
        {
            
            if( x.p.get(i).name == name){  a = true;
            a1 = x.p.get(i); }
           
        }
        if(isHabitable(a1))
        a = true
        else
        a = false
        return a;
    }
    
    
}    