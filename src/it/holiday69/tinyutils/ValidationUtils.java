/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class ValidationUtils {

  public static boolean isValidURL(String url) {
    return isValidURL(url, new String[] {"http", "https"});
  }

  public static boolean isValidURL(String url, String[] schemeAllowedList) {

    String regex = "\\b(" + StringUtils.join("|", schemeAllowedList) + ")://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    if(url.matches(regex))
      return true;
    else
      return false;
  }
  
  public static boolean isValidEmailAddress(String emailAddress){  
   String  expression="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
   CharSequence inputStr = emailAddress;  
   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
   Matcher matcher = pattern.matcher(inputStr);  
   return matcher.matches();  
  
 }  

}
