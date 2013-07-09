/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils.help;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class ConversionHelper {

  private boolean _strict;
  
  public ConversionHelper() {
    _strict = true;
  }
  public ConversionHelper(boolean strict) {
    _strict = strict;
  }
  
  public Integer stringToInt(String value) {

    if(value == null)
      return _strict?null:0;
    
    value = value.trim();

    try {
      return Integer.parseInt(value);
    } catch(Throwable th) {
      return _strict?null:0;
    }
  }

  public Long stringToLong(String value) {

    if(value == null)
      return _strict?null:0l;
    
    value = value.trim();
    
    try {
      
      return Long.parseLong(value);
      
    } catch(Throwable th) {
      return _strict?null:0l;
    }
  }

  public Boolean stringToBoolean(String value) {

    if(value == null)
      return _strict?null:false;
    
    value = value.trim();
    
    try {
      return Boolean.parseBoolean(value);
    } catch(Throwable th) {
      return _strict?null:false;
    }
  }

  public Float stringToFloat(String value) {

    if(value == null)
      return _strict?null:0f;

    value = value.trim();
    
    try {
      return Float.parseFloat(value);
    } catch(Throwable th) {
      return _strict?null:0f;
    }
  }
}

