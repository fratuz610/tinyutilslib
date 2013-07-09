/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class StringUtils {

  public static String byteArrayToHexString(byte[] byteArray) {
    String hexString = "";
    for  (int i = 0; i < byteArray.length; i++) {
     hexString += String.format("%02X%s", byteArray[i], "");
    }
    return hexString;
  }

  public static String trimAll(String src) {

    String ret = src.trim();

    while(ret.endsWith("\n"))
      ret = ret.substring(0, src.length()-1);

    while(ret.endsWith("\r"))
      ret = ret.substring(0, src.length()-1);

    return ret;
  }
    
  public static boolean isEmpty(String val) {
    if(val == null)
      return true;
    
    if(val.trim().equals(""))
      return true;
    
    return false;
  }
  
  public static boolean hasContent(String val) {
    return !isEmpty(val);
  }
  
  public static List<String> splitList(String divider, String src) {
    return Arrays.asList(src.split(divider));
  }
  
  public static String join(String glue, String[] paramList) {
    return join(glue, Arrays.asList(paramList));
  }
  
  public static String join(String glue, List<?> paramList) {
    StringBuilder builder = new StringBuilder();
     Iterator<?> iter = paramList.iterator();
     while (iter.hasNext()) {
         builder.append(iter.next());
         if (!iter.hasNext()) {
           break;                  
         }
         builder.append(glue);
     }
     return builder.toString();
  }
  
  public static String head(String src, String dividerRegex) {
    String[] splitList = src.split(dividerRegex);
    if(splitList.length == 0)
      return src;
    else
      return splitList[0];
  }
  
  public static String tail(String src, String dividerRegex) {
    String[] splitList = src.split(dividerRegex);
    if(splitList.length == 0)
      return src;
    else
      return splitList[splitList.length-1];
  }
  
  public static String humanReadableByteCount(long bytes) {
    return humanReadableByteCount(bytes, false);
  }
  
  public static String humanReadableByteCount(long bytes, boolean si) {
    int unit = si ? 1000 : 1024;
    if (bytes < unit) return bytes + " B";
    int exp = (int) (Math.log(bytes) / Math.log(unit));
    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
  }

  public static String safeSubstring(String src, int maxCharCount) {
    if(isEmpty(src))
      return src;
    
    if(src.length() <= maxCharCount)
      return src;
    
    return src.substring(0, maxCharCount);
  }

}
