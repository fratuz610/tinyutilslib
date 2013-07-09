/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class TimeFormatUtils {

  /**
  * Simple wrapper for the SimpleDateFormat class with a default date format of yyyy-MM-dd HH:mm:ss
  *
  * @param ts the source timestamp
  * @return the formatted String representation of the timestamp
  */
  public static String formatTimestamp(long ts) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(new Date(ts));
  }
  
  /**
  * Simple wrapper for the SimpleDateFormat class
  *
  * @param ts the source timestamp
  * @param format the format string used to convert the timestamp into a string
  * @return the formatted String representation of the timestamp
  */
  public static String formatTimestamp(long ts, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    return formatter.format(new Date(ts));
  }
  
  
  /**
  * Simple wrapper for the SimpleDateFormatter class
  *
  * @param ts the source timestamp
  * @param format the format string used to convert the timestamp into a string
  * @param locale the locale to use during the conversion
  * @return the formatted String representation of the timestamp
  */
  public static String formatTimestamp(long ts, String format, Locale locale) {
    SimpleDateFormat formatter = new SimpleDateFormat(format, locale);
    return formatter.format(new Date(ts));
  }

  /**
  * Returns the time distance between the current timestamp and the given one in plain english format
  *
  * @param ts the source timestamp
  * @return a String representation of time gap between the current timestamp and the source timestamp
  */
  public static String timestampToPresent(long ts) {
    long now = System.currentTimeMillis();

    long delta = now - ts;

    String retString = "";

    if(delta < 60000) {
      retString = "less than a minute ago";
    } else {

      int daysAgo = (int) delta/(24 * 60 * 60 * 1000);
      int hoursAgo = (int) delta/(60 * 60 * 1000);
      int minutesAgo = (int) delta/(60 * 1000);

      while(minutesAgo >= 60) minutesAgo -= 60;
      while(hoursAgo >= 24) hoursAgo -= 24;

      if(daysAgo > 0)
        retString += daysAgo + " day(s) ";
      if(hoursAgo > 0)
        retString += hoursAgo + " hour(s) ";
      if(minutesAgo > 0)
        retString += minutesAgo + " minutes(s) ";

      retString += "ago";
    }

    return retString;
  }
  
  public static String getStringDifference(long difference)
  {
    int days = (int)difference / 86400000;
    int hours = (int)difference / 3600000;
    int minutes = (int)difference / 60000;
    int seconds = (int)difference / 1000;
    int ms = (int)difference;

    if (ms < 1000) {
      return ms + " ms";
    }
    if (seconds < 60) {
      return seconds + " sec";
    }
    if (minutes < 60) {
      return minutes + " min " + getStringDifference(difference - minutes * 60 * 1000);
    }
    if (hours < 24) {
      return hours + " hr " + getStringDifference(difference - hours * 60 * 60 * 1000);
    }
    return days + " days " + getStringDifference(difference - days * 24 * 60 * 60 * 1000);
  }
   
}
