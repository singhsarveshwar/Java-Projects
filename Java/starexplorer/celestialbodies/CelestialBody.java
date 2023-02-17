package celestialbodies;
import java.util.*;
import java.io.*;

import java.lang.IllegalArgumentException;

public class CelestialBody
{
   public String name;
   public double mass;
   public int massExponent ;
   public CelestialBodyType bodyType;
    public CelestialBody(String name, double mass,int massExponent,CelestialBodyType bt)
    {
        if ( (name.isEmpty() || name == null) && (mass <=0) && 
        (bt != CelestialBodyType.MS_STAR || bt != CelestialBodyType.GAS_GAINT || bt != CelestialBodyType.TERRESTRIAL_PLANET)
        )
        {
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
        this.mass = mass;
        this.massExponent = massExponent;
        this.bodyType = bt;
    }
    @Override
    public String toString()
    {
        return this.name + "(" + Integer.toString(10^massExponent) +","+ bodyType.name()+ ")";
    }

}