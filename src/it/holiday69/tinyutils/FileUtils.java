/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class FileUtils {

  /**
  * Outputs the content of a string to a file
  *
  * @param fileLocation the location of the file to output to
  * @param content the content to write to the file
  * @return true upon success. False otherwise
  */
  public static boolean filePutContents(String fileLocation, String content){
    
    try {
      FileOutputStream fout = new FileOutputStream(fileLocation);
      fout.write(content.getBytes());
      fout.close();
      return true;
    } catch(IOException ex) {
      return false;
    }
  }
  
  /**
  * Outputs the content of a string to a file
  *
  * @param file the file to write to
  * @param content the content to write to the file
  * @return true upon success. false otherwise
  */
  public static boolean filePutContents(File file, String content){
    
    try {
      FileOutputStream fout = new FileOutputStream(file);
      fout.write(content.getBytes());
      fout.close();
      return true;
    } catch(IOException ex) {
      return false;
    }
  }

}
