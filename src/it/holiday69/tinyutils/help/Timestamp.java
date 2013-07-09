/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fratuz610
 */
public class Timestamp {
  
  private long _ts;
  
  private GregorianCalendar _calendar = new GregorianCalendar();
	
	public Timestamp() { _ts = new Date().getTime(); }
	
	public Timestamp(long ts) { _ts = ts; }
  
  public static Timestamp getTodayTimestamp() {
    
    Calendar cal = new GregorianCalendar();
    
    cal.setTimeInMillis(new Date().getTime());
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    
    return new Timestamp(cal.getTimeInMillis());
  }
	
  public static Timestamp getTomorrowTimestamp() { return getTodayTimestamp().plus(1, TimeUnit.DAYS); }
  public static Timestamp getYesterdayTimestamp() { return getTodayTimestamp().minus(1, TimeUnit.DAYS); }
  
  public Timestamp plusMillisec(long millisec) { _ts += millisec; return this; }
	public Timestamp minusMillisec(long millisec) { _ts -= millisec; return this; }
	  
  public Timestamp plusMinutes(long minutes) { _ts += TimeUnit.MINUTES.toMillis(minutes); return this; }
	public Timestamp minusMinutes(long minutes) { _ts -= TimeUnit.MINUTES.toMillis(minutes); return this; }
	
	public Timestamp plusHours(long hours) { _ts += TimeUnit.HOURS.toMillis(hours); return this; }
	public Timestamp minusHours(long hours) { _ts -= TimeUnit.HOURS.toMillis(hours); return this; }
	
	public Timestamp plusDays(long days) { _ts += TimeUnit.DAYS.toMillis(days); return this; }
	public Timestamp minusDays(long days) { _ts -= TimeUnit.DAYS.toMillis(days); return this; }
	
	public Timestamp plusWeeks(long weeks) { _ts += TimeUnit.DAYS.toMillis(weeks * 7); return this; }
	public Timestamp minusWeeks(long weeks) { _ts -= TimeUnit.DAYS.toMillis(weeks * 7); return this; }
	
	public Timestamp plusMonths(long months) { _ts += TimeUnit.DAYS.toMillis(months * 30); return this; }
	public Timestamp minusMonths(long months) { _ts -= TimeUnit.DAYS.toMillis(months * 30); return this; }
  
  public Timestamp plus(long value, TimeUnit tm) { _ts += tm.toMillis(value); return this; }
  public Timestamp minus(long value, TimeUnit tm) { _ts -= tm.toMillis(value); return this; }
  
  public int getYear() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.YEAR); }
  public int getMonth() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.MONTH); }
  public int getDay() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.DAY_OF_MONTH); }
  public int getHour24() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.HOUR_OF_DAY); }
  public int getHour12() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.HOUR); }
  public int getMinutes() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.MINUTE); }
  public int getSeconds() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.SECOND); }
  public int getMillisec() { _calendar.setTimeInMillis(_ts); return _calendar.get(Calendar.MILLISECOND); }
  
	public long toLong() { return _ts; }
  
  @Override
  public String toString() { 
    return toString("yyyy/MM/dd HH:mm:ss", TimeZone.getDefault());
  }
  
  public String toString(TimeZone tz) { 
    return toString("yyyy/MM/dd HH:mm:ss", tz);
  }
  
  public String toString(String dateFormatString) { 
    return toString(dateFormatString, TimeZone.getDefault());
  }
  
   public String toString(String dateFormatString, TimeZone tz) { 
    Calendar cal = Calendar.getInstance(tz);
    DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    dateFormat.setCalendar(cal);
    return dateFormat.format((new Date(_ts)));
  }
}
