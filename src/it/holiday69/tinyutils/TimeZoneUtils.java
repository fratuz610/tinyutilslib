/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class TimeZoneUtils {

  public static Map<String, TimeZoneObject> getTimeZoneMap() {
    
    String[] timeZoneIDList = TimeZone.getAvailableIDs();

    Arrays.sort(timeZoneIDList);

    Calendar cl = new GregorianCalendar();

    Map<String, TimeZoneObject> timeZoneMap = new LinkedHashMap<String, TimeZoneObject>();

    for(String timeZoneID: timeZoneIDList) {

      if(timeZoneID.length() < 4)
        continue;

      long milliSecGap = TimeZone.getTimeZone(timeZoneID).getOffset(cl.getTimeInMillis());
      float timeGap = (float) milliSecGap/1000/60/60;

      int hoursGap = (int) Math.floor(timeGap);
      float minutesPercGap = timeGap - hoursGap;
      int minutesGap = (int) (minutesPercGap * 60);

      String minutesGapString;
      if(minutesGap < 10)
        minutesGapString = "0" + minutesGap;
      else
        minutesGapString = "" + minutesGap;

      TimeZoneObject tmpTimeZoneObj = new TimeZoneObject();
      tmpTimeZoneObj.javaID = timeZoneID;
      tmpTimeZoneObj.gapString = hoursGap + ":" + minutesGapString;
      tmpTimeZoneObj.utcMillisecGap = milliSecGap;

      timeZoneMap.put(timeZoneID, tmpTimeZoneObj);
    }

    return timeZoneMap;

  }
  
  public static class TimeZoneObject {

    public String javaID;
    public String gapString;
    public long utcMillisecGap;

    @Override
    public String toString() {
      return "(" + gapString + ") " + javaID;
    }
  }
}
