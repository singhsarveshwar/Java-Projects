package celestialbodies;
import java.util.*;
import java.io.*;
import java.lang.IllegalArgumentException;
public class Star extends CelestialBody
{
  public  int surfaceTemperature;
    public Star(String name, double mass, int massExponent,CelestialBodyType bt, int temp)
    {
        super(name,mass,massExponent,bt);
        this.surfaceTemperature = temp;
        if(bt != CelestialBodyType.MS_STAR)
        {
            throw new IllegalArgumentException ("not MS_STAR");
        }
    }
}