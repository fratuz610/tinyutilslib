/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils.help;

import it.holiday69.tinyutils.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class ByteHelper {

  public byte[] wrapperListToByteArray(List<Byte> list){
    byte[] byteArray = new byte[list.size()];
    for(int i = 0; i<list.size(); i++){
      byteArray[i] = list.get(i);
    }
    return byteArray;
  }

  public String toHexString(byte[] byteList) {
    StringBuilder buf = new StringBuilder();
    char[] hexChars = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F' };
    int len = byteList.length;
    int high = 0;
    int low = 0;
    for (int i = 0; i < len; i++) {
        high = ((byteList[i] & 0xf0) >> 4);
        low = (byteList[i] & 0x0f);
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }
    return buf.toString();
  }

  /* alternative */
  public String byteArrayToHexString(byte[] byteArray) {
    String hexString = "";
    for  (int i = 0; i < byteArray.length; i++) {
     hexString += String.format("%02X%s", byteArray[i], "");
    }
    return hexString;
  }

  public byte[] fromHexString(String hexString) throws Exception {

    if(hexString.length() % 2 != 0)
      throw new Exception("Malformed hexString: must contain a even number of chars");

    int arrLength = hexString.length() >> 1;
    byte buf[] = new byte[arrLength];

    for ( int ii = 0; ii < arrLength; ii++ )
    {
        int index = ii << 1;

        String l_digit = hexString.substring( index, index + 2 );
        buf[ii] = ( byte ) Integer.parseInt( l_digit, 16 );
    }

    return buf;
  }

}
