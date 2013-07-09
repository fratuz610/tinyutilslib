/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils.help;

import it.holiday69.tinyutils.*;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class ValidationHelper {

  public boolean isValidURL(String url) {
    return isValidURL(url, new String[] {"http", "https"});
  }

  public boolean isValidURL(String url, String[] schemeAllowedList) {

    String regex = "\\b(" + StringUtils.join("|", schemeAllowedList) + ")://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    if(url.matches(regex))
      return true;
    else
      return false;
  }

}
