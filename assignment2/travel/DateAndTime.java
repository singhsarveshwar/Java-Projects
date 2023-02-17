package assignment2.travel;

import java.util.*;
import java.io.*;
public class DateAndTime
{
    private int year,month,day,hour,minute;
    public DateAndTime(int year,int month,int day,int hour,int minute)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour=hour;
        this.minute=minute;
    }
    public DateAndTime()
    {
        this.year = 2021;
        this.month = 12;
        this.day=22;
        this.hour=04;
        this.minute=30;
    }
    @Override
    public String toString()
    {
        return "`"+ Integer.toString(year)+"."+Integer.toString(month)+
        "."+Integer.toString(day)+"at"+Integer.toString(hour)+
        ":"+Integer.toString(minute);
    }
    public String getTime()
    {
        return Integer.toString(hour)+
        ":"+Integer.toString(minute);
    }
    public int getYear()
    {
        return this.year;
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getDay()
    {
        return this.day;
    }
    public int getHour()
    {
        return this.hour;
    }
    public int getMinute()
    {
        return this.minute;
    }
}