package celestialbodies;
import java.util.*;
import java.io.*;
import java.lang.IllegalArgumentException;
public class Planet extends CelestialBody
{
    public WorldType worldType;
    public int oxygen;
    public int nitrogen;
    public int OtherElements;
    public Planet(String name, double mass, int massExponent,CelestialBodyType bt,
                    int oxy,int nitro,int other)
                    {
                         super(name,mass,massExponent,bt);
                         this.oxygen=oxy;
                         this.nitrogen=nitro;
                         this.OtherElements = other;
                    }
     @Override
    public String toString()
    {
        return this.name + "(" + Integer.toString(10^massExponent) +","+ bodyType.name()+ ")"
        + "of LANDMASS WITH (" + Integer.toString(oxygen) +" OXYGEN,"
        + Integer.toString(nitrogen) + "NITROGEN," + Integer.toString(OtherElements) +"OTHER)"  ;
    }                
}