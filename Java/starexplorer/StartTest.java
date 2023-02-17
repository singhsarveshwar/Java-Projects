import static org.junit.jupiter.api.Assertions.*;
import celestialbodies.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
public class StartTest
{
    CelestialBody a = new CelestialBody("Earth",10.0,1,CelestialBodyType.TERRESTRIAL_PLANET);
    @Test
    public void TestEarth()
    {
           assertEquals("Earth(10,TERRESTRIAL_PLANET)",a);
    }
    Planet b = new Planet ("Earth",10.0,1,CelestialBodyType.TERRESTRIAL_PLANET,78,21,1);
    @Test
    public void testEarthAsPlanet()
    {
assertEquals("Planet Earth(5.972e24,TERRESTRIAL_PLANET) of LANDMASS with (78 oxygen, 21 nitrogen, 1 other)",p);
    } 
     

}