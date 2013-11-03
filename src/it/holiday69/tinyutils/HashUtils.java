/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 *
 * @author Stefano Fratini <mail@stefanofratini.it>
 */
public class HashUtils {

  // SHA25
  public static byte[] SHA256(String source) {
    try {
      MessageDigest sha = MessageDigest.getInstance("SHA-256");
      return sha.digest(source.getBytes());
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(HashUtils.class.getSimpleName()).severe("Unable to use SHA256 Encryption, returning null: " + ex.getMessage());
      return null;
    }
  }
  
  public static String base64MD5(String source) { return Base64.encodeBytes(hash(source, "MD5")); }
  
  public static String base64SHA1(String source) { return Base64.encodeBytes(hash(source, "SHA-1")); }
  
  public static String base64SHA256(String source) { return Base64.encodeBytes(hash(source, "SHA-256")); }
  
  public static String base64SHA512(String source) { return Base64.encodeBytes(hash(source, "SHA-512")); }
  
  private static byte[] hash(String source, String hashAlgo) {
    try {
      MessageDigest sha = MessageDigest.getInstance(hashAlgo);
      return sha.digest(source.getBytes());
    } catch (Throwable th) {
      Logger.getLogger(HashUtils.class.getSimpleName()).severe("Unable to use SHA256 Encryption, returning null: " + th.getMessage());
      return null;
    }
  }
  
  public static String hexMD5(String source) { return bytesToHex(hash(source, "MD5")); }
  
  public static String hexSHA1(String source) { return bytesToHex(hash(source, "SHA-1")); }
  
  public static String hexSHA256(String source) { return bytesToHex(hash(source, "SHA-256")); }
  
  public static String hexSHA512(String source) { return bytesToHex(hash(source, "SHA-512")); }
  
  private static char[] hexArray = "0123456789ABCDEF".toCharArray();
  private static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    int v;
    for ( int j = 0; j < bytes.length; j++ ) {
        v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}


}
