/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

import it.holiday69.tinyutils.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author fratuz610
 */
public class JarHelper {
  
  public byte[] getByteArrayFromJar(Class classForClassLoader, String pathName) throws Exception {
    
    InputStream in = classForClassLoader.getResourceAsStream(pathName);
    
    if(in == null)
      throw new Exception("The specified file: " + pathName + " does not exist within the classloader linked to " + classForClassLoader.getName());
    
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    new IOHelper().copy(in, out);
    
    return out.toByteArray();
  }
    
  public File getTempFileFromJar(Class classForClassLoader, String pathName, String prefix) throws Exception {
    
    InputStream in = classForClassLoader.getResourceAsStream(pathName);
    
    if(in == null)
      throw new Exception("The specified file: " + pathName + " does not exist within the classloader linked to " + classForClassLoader.getName());
    
    File retFile = null;
    retFile = File.createTempFile(prefix, "." + StringUtils.tail(pathName, "\\."));
    
    FileOutputStream out = new FileOutputStream(retFile);
    
    new IOHelper().copy(in, out);
    
    out.flush();
    out.close();
    
    return retFile;
  }
  
  public void copyFileFromJar(Class classForClassLoader, String pathName, File targetFile) throws Exception {
    
    InputStream in = classForClassLoader.getResourceAsStream(pathName);
    
    if(in == null)
      throw new Exception("The specified file: " + pathName + " does not exist within the classloader linked to " + classForClassLoader.getName());
    
    FileOutputStream out = new FileOutputStream(targetFile);
    
    new IOHelper().copy(in, out);
    
    out.flush();
    out.close();
  }
}
