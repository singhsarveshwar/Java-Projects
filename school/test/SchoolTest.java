package school.test;
import school.subject.Subject;
import school.schedule.*;
import school.subject.*;
import school.test.*;
//import  org.junit.Before;
import java.util.ArrayList;
//import org.junit.Test;



import java.io.*;
import org.junit.*; 
import static org.junit.Assert.*;//assertThrows;
import static org.junit.Assert.assertEquals;
public class SchoolTest{
   Schedule schedules[] = new Schedule[100];
    
    // Schedule scheduleInvalid = new Schedule("schedule4.txt") ;
    // schedules[0] = new Schedule("schedule4.txt");
    @Before
    public void beforeEach() {
        schedules[0] = new Schedule("schedule4.txt");
        schedules[1] = new Schedule("schedule5.txt");
        schedules[2] = new Schedule("schedule6.txt");
        schedules[3] = new Schedule("schedule7.txt");

       
    }
    //System.out.println(schedules[0]);

    @Test
    public void getClassesPerDay(){
        ArrayList<Subject> a = schedules[0].getClassPerDay(0);
           assertEquals("LITERATURE",a.get(0).name());
           assertEquals("LITERATURE",a.get(1).name());
           assertEquals("LITERATURE",a.get(2).name());
            assertEquals("HISTORY",a.get(3).name());  
            assertEquals("LITERATURE",a.get(4).name());

        ArrayList<Subject> b = schedules[1].getClassPerDay(0);
         assertEquals("PHYSICS",  b.get(0).name());
           assertEquals("HISTORY",b.get(1).name());
           assertEquals("CHEMISTRY",b.get(2).name());

        ArrayList<Subject> c = schedules[1].getClassPerDay(1);
            assertEquals("CHEMISTRY",c.get(0).name());
            assertEquals("PHYSICS",c.get(1).name());
            assertEquals("HISTORY",c.get(2).name());
        ArrayList<Subject> d = schedules[1].getClassPerDay(2);
            assertEquals("HISTORY",d.get(0).name());
            assertEquals("CHEMISTRY",d.get(1).name());
            assertEquals("PHYSICS",d.get(2).name());
    }

    @Test
    public void suitable()
    {
         
        assertEquals(true,schedules[0].isSuitableForYear(5));
        assertEquals(true,schedules[1].isSuitableForYear(7));
        assertEquals(true,schedules[2].isSuitableForYear(6));
        assertEquals(true,schedules[2].isSuitableForYear(7));
    }
    @Test
    public void scheduledClassType()
    {
        int a = (schedules[0].get1(1,1)).ordinal();
        int c;
        if( a == 0 || a ==1 )
        c =0 ;
        else
        c =1;
        assertEquals("HUMANITY", (SubjectType.values()[c].name()));


           int a1 = (schedules[1].get1(0,0)).ordinal();
        int c1;
        if( a1 == 0 || a1 ==1 )
        c1 =0 ;
        else
        c1 =1;
        assertEquals("SCIENCE", (SubjectType.values()[c1].name()));

           int a2 = (schedules[2].get1(1,0)).ordinal();
        int c2;
        if( a2 == 0 || a2 ==1 )
        c2 =0 ;
        else
        c2 =1;
        assertEquals("HUMANITY", (SubjectType.values()[c2].name()));

           int a3 = (schedules[3].get1(0,0)).ordinal();
        int c3;
        if( a3 == 0 || a3 ==1 )
        c3 =0 ;
        else
        c3 =1;
        assertEquals("SCIENCE", (SubjectType.values()[c3].name()));
    }
   @Test
  public void notSuitable(){

       assertEquals(false,schedules[0].isSuitableForYear(4));
        assertEquals(false,schedules[1].isSuitableForYear(5));
        assertEquals(false,schedules[2].isSuitableForYear(5));
        assertEquals(false,schedules[3].isSuitableForYear(6));

   }
   @Test 
   public void shortContent(){
        try{
            Schedule scheduleInvalid = new Schedule("scheduleInvalid.txt");
        }
        catch(IllegalStateException e)
        {

        }
        
   }

    @Test(expected = IllegalArgumentException.class)
   public void invalidName(){
        Schedule schedule1 = new Schedule("afjhftdfgxhgfg.txt");
   }
 }