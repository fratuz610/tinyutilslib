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
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class HashUtils {

  // SHA256

  public static byte[] SHA256(String source) {
    try {
      MessageDigest sha = MessageDigest.getInstance("SHA-256");
      return sha.digest(source.getBytes());
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(HashUtils.class.getSimpleName()).severe("Unable to use SHA256 Encryption, returning null: " + ex.getMessage());
      return null;
    }
  }
  
  public static String base64MD5(String source) { return base64Hash(source, "MD5"); }
  
  public static String base64SHA1(String source) { return base64Hash(source, "SHA-1"); }
  
  public static String base64SHA256(String source) { return base64Hash(source, "SHA-256"); }
  
  public static String base64SHA512(String source) { return base64Hash(source, "SHA-512"); }
  
  private static String base64Hash(String source, String hashAlgo) {
    try {
      MessageDigest sha = MessageDigest.getInstance(hashAlgo);
      return Base64.encodeBytes(sha.digest(source.getBytes()));
    } catch (Throwable th) {
      Logger.getLogger(HashUtils.class.getSimpleName()).severe("Unable to use SHA256 Encryption, returning null: " + th.getMessage());
      return null;
    }
  }


}
