/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class ConversionUtils {
  
  public static boolean strict = true;

  public static Integer stringToInt(String value) {

    if(value == null)
      return strict?null:0;
    
    value = value.trim();

    try {
      return Integer.parseInt(value);
    } catch(Throwable th) {
      return strict?null:0;
    }
  }

  public static Long stringToLong(String value) {

    if(value == null)
      return strict?null:0l;
    
    value = value.trim();
    
    try {
      return Long.parseLong(value);
    } catch(Throwable th) {
      return strict?null:0l;
    }
  }

  public static Boolean stringToBoolean(String value) {

    if(value == null)
      return strict?null:false;
    
    value = value.trim();
    
    try {
      return Boolean.parseBoolean(value);
    } catch(Throwable th) {
      return strict?null:false;
    }
  }

  public static Float stringToFloat(String value) {

    if(value == null)
      return strict?null:0f;

    value = value.trim();
    
    try {
      return Float.parseFloat(value);
    } catch(Throwable th) {
      return strict?null:0f;
    }
  }
}

