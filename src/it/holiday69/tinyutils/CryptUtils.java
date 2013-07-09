/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import java.security.SignatureException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class CryptUtils {

  private static final String DEFAULT_AES_KEY_BASE = "CORE9";

  // AES ALGORYTHM

  // AES Decrypt to String
  public static String AESDecryptText(String base64CipherText) {
    return AESDecryptText(base64CipherText, null);
  }

  public static String AESDecryptText(String base64CipherText, String stringKey) {

    try {
      return new String(AESDecrypt(Base64.decode(base64CipherText), stringKey));
    } catch(Exception ex) {
      throw new RuntimeException("Unable to AES-Decrypt: " + ex.getMessage());
    }
  }

  // AES Decrypt to Hex
  public static byte[] AESDecryptHex(String hexCipherText) {
    return AESDecryptHex(hexCipherText, null);
  }

  public static byte[] AESDecryptHex(String hexCipherText, String stringKey) {
    try {
      return AESDecrypt(ByteUtils.fromHexString(hexCipherText), stringKey);
    } catch(Exception ex) {
      throw new RuntimeException("Unable to AES-Decrypt: " + ex.getMessage());
    }
  }

  // AES Decrypt to ByteArray
  public static byte[] AESDecrypt(byte[] cipherData) {
    return AESDecrypt(cipherData, null);
  }

  public static byte[] AESDecrypt(byte[] cipherData, String stringKey) {
    try {
      byte[] key = (stringKey != null)?HashUtils.SHA256(stringKey):HashUtils.SHA256(DEFAULT_AES_KEY_BASE);
      byte[] input = cipherData;
      byte[] output = null;
      SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, keySpec);
      output = cipher.doFinal(input);
      return output;
    } catch (Exception ex) {
      throw new RuntimeException("Unable to AES-Decrypt: " + ex.getMessage());
    }
  }

  // AES Encrypt to String
  public static String AESEncryptToString(byte[] byteList) {
    return AESEncryptToString(byteList, null);
  }

  public static String AESEncryptToString(byte[] byteList, String stringKey) {
    byte[] encryptedByteArray = AESEncrypt(byteList, stringKey);
    return Base64.encodeBytes(encryptedByteArray);
  }
  
  public static String AESEncryptToString(String plainText) {
    return AESEncryptToString(plainText.getBytes(), null);
  }
  
  public static String AESEncryptToString(String plainText, String stringKey) {
    byte[] encryptedByteArray = AESEncrypt(plainText.getBytes(), stringKey);
    return Base64.encodeBytes(encryptedByteArray);
  }

  // AES Encrypt to HEX
  public static String AESEncryptToHex(String plainText) {
    return AESEncryptToHex(plainText.getBytes(), null);
  }
  
  public static String AESEncryptToHex(byte[] byteList) {
    return AESEncryptToHex(byteList, null);
  }

  public static String AESEncryptToHex(byte[] byteList, String stringKey){
    byte[] encryptedByteArray = AESEncrypt(byteList, stringKey);
    return ByteUtils.toHexString(encryptedByteArray);
  }

  // AES Encrypt to Byte Array (default)
  public static byte[] AESEncrypt(byte[] byteList, String stringKey){
    try {
      byte[] key = (stringKey != null)?HashUtils.SHA256(stringKey):HashUtils.SHA256(DEFAULT_AES_KEY_BASE);
      byte[] input = byteList;
      byte[] output = null;

      SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, keySpec);
      output = cipher.doFinal(input);
      return output;

    } catch (Exception ex) {
      throw new RuntimeException("Unable to AES-Encrypt: " + ex.getMessage());
    }
  }
  
  //------------------------------
	// HMAC SHA1
	//------------------------------
	
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	public static String calculateRFC2104HMAC(String data, String key) throws SignatureException {

    try {

      // get an hmac_sha1 key from the raw key bytes
      SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);

      // get an hmac_sha1 Mac instance and initialize with the signing key
      Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
      mac.init(signingKey);

      // compute the hmac on input data bytes
      byte[] rawHmac = mac.doFinal(data.getBytes());

      // base64-encode the hmac
      return Base64.encodeBytes(rawHmac);

    } catch (Throwable th) {
      throw new SignatureException("Failed to generate HMAC : " + th.getMessage());
    }

	 }
  
  //------------------------------
	// GENERATE RANDOM
	//------------------------------
	
	public static final String RANDOM_CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public static final int RANDOM_LENGTH = 32;
  
	public static String generateRandom(int randomLength) {
	
    StringBuilder salt = new StringBuilder();
    while(salt.length() < RANDOM_LENGTH) {
      int randPos = (int) Math.floor(Math.random() * RANDOM_CHAR_LIST.length());
        salt.append(RANDOM_CHAR_LIST.charAt(randPos));
    }
    return salt.toString();
	}
  
  
  private static final BlockingDeque<String> _sentRandomList = new LinkedBlockingDeque<String>();
	
  //------------------------------
	// GENERATE UNIQUE RANDOM
	//------------------------------
  
	public static String generateUniqueRandom() {
	
		String candidate = null;
		
		do {
			StringBuilder salt = new StringBuilder();
			while(salt.length() < RANDOM_LENGTH) {
				int randPos = (int) Math.floor(Math.random() * RANDOM_CHAR_LIST.length());
			    salt.append(RANDOM_CHAR_LIST.charAt(randPos));
			}
			candidate = salt.toString();
           
		} while(_sentRandomList.contains(candidate));
		
		_sentRandomList.add(candidate);
		
		while(_sentRandomList.size() > 50) _sentRandomList.removeFirst();
		
		return candidate;
	}

}
