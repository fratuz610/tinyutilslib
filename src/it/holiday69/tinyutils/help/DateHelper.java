/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fratuz610
 */
public class DateHelper {
  
  public String getTimeDateString() {
    return getTimeDateString(new Date().getTime());
  }
	
	public String getTimeDateString(long ts) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-S");
		
		return simpleDateFormat.format(new Date(ts));
	}

}
