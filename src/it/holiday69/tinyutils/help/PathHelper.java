/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

/**
 *
 * @author fratuz610
 */
public class PathHelper {

	public String extractFileName(String path) {
    
    path = path.replaceAll("\\\\", "/");
    
    if(path.indexOf("/") != -1) {
      return new StringHelper().tail(path, "/");
    } else
      return path;
  }
  
  public static void main(String[] args) {
    
    System.out.println(new PathHelper().extractFileName("d:/tmp/test-app.exe"));
    
    System.out.println(new PathHelper().extractFileName("d:\\tmp\\test-app.exe"));
    
  }
}
