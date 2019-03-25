package com.nnt.backend.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Component;
@Component
public class TimeZoneUtil {
	public  Date offsetTimeZone(Date date, String fromTZ, String toTZ){

        //construct FROM and TO Timezone instances
        TimeZone fromTimeZone = TimeZone.getTimeZone(fromTZ);
        TimeZone toTimeZone = TimeZone.getTimeZone(toTZ);

        //Get a Calendar instance using the default time zone and locale.
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(toTZ));

        // Set the calendar's time with the given date
        calendar.setTimeZone(fromTimeZone);
        calendar.setTime(date);

        //System.out.println("--------------------TimeUtile: "+calendar.getTime());

        // FROM timezone to UTC
        calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset()*(-1));
        if(fromTimeZone.inDaylightTime(calendar.getTime())){
            /*System.out.println("fromTimeZone in Daylight");*/
            calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() *(-1));
            calendar.getTimeZone().getDisplayName();
        }
        //System.out.println("-----------------------FROM timezone to UTC: "+calendar.getTime() + " ---- " + fromTimeZone.getRawOffset()*(-1));

        // UTC to Timezone
        calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
        if(toTimeZone.inDaylightTime(calendar.getTime())){
            /*System.out.println("toTimeZone in Daylight");*/
            calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
        }
       // System.out.println("-------------------------UTC to Timezone: "+calendar.getTime() + " ---- " + toTimeZone.getRawOffset());
        return calendar.getTime();
    }
}
