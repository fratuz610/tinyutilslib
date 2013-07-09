/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils.help;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class HashHelper {

  private byte[] _source;
  
  public HashHelper(byte[] source) {
    _source = source;
  }
  
  public HashHelper(String source) {
    _source = source.getBytes();
  }
  
  public byte[] SHA256() {
    try {
      MessageDigest sha = MessageDigest.getInstance("SHA-256");
      return sha.digest(_source);
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(HashHelper.class.getSimpleName()).severe("Unable to use SHA256 Encryption, returning null: " + ex.getMessage());
      return null;
    }
  }


}
