/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author fratuz610
 */
public class TimestampUtils {
  
  public static long getNow() {
		return new Date().getTime();
	}
	
	public static long get24HrsAgo() {
		return getNow() - (1000 * 60 * 60 * 24);
	}
	
	public static long getTomorrowTimestamp() {
		return getTodayTimestamp() + (1000 * 60 * 60 * 24);
	}
	public static long getYesterdayTimestamp() {
	    return getTodayTimestamp() - (1000 * 60 * 60 * 24);
	}
	
	public static long getTodayTimestamp() {
	    Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
	    cal.setTimeInMillis(new Date().getTime());
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTimeInMillis();
	}
}
