/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fratuz610
 */
public class HashUtilsTest {
  
  public HashUtilsTest() {
  }

  /**
   * Test of base64MD5 method, of class HashUtils.
   */
  @Test
  public void testBase64MD5() {
    System.out.println("base64MD5");
    String source = "hello world";
    String expResult = "XrY7u+Ae7tCTyyK7j1rNww==";
    String result = HashUtils.base64MD5(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of base64SHA1 method, of class HashUtils.
   */
  @Test
  public void testBase64SHA1() {
    System.out.println("base64SHA1");
    String source = "hello world";
    String expResult = "Kq5sNclPz7QV2+lfQIuc6R7oRu0=";
    String result = HashUtils.base64SHA1(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of base64SHA256 method, of class HashUtils.
   */
  @Test
  public void testBase64SHA256() {
    System.out.println("base64SHA256");
    String source = "hello world";
    String expResult = "uU0nuZNNPgilLlLX2n2r+sSE7+N6U4DukIj3rOLvzek=";
    String result = HashUtils.base64SHA256(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of base64SHA512 method, of class HashUtils.
   */
  @Test
  public void testBase64SHA512() {
    System.out.println("base64SHA512");
    String source = "hello world";
    String expResult = "MJ7MSJwS1utMxA9QyQLytNDtd+5RGnx6m808qG1M2G+YndNbxf9JlnDaNCVbRbDP2DDoH2Bdz33FVC6TrpzXbw==";
    String result = HashUtils.base64SHA512(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of hexMD5 method, of class HashUtils.
   */
  @Test
  public void testHexMD5() {
    System.out.println("hexMD5");
    String source = "hello world";
    String expResult = "5eb63bbbe01eeed093cb22bb8f5acdc3".toUpperCase();
    String result = HashUtils.hexMD5(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of hexSHA1 method, of class HashUtils.
   */
  @Test
  public void testHexSHA1() {
    System.out.println("hexSHA1");
    String source = "hello world";
    String expResult = "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed".toUpperCase();
    String result = HashUtils.hexSHA1(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of hexSHA256 method, of class HashUtils.
   */
  @Test
  public void testHexSHA256() {
    System.out.println("hexSHA256");
    String source = "hello world";
    String expResult = "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9".toUpperCase();
    String result = HashUtils.hexSHA256(source);
    assertEquals(expResult, result);
  }

  /**
   * Test of hexSHA512 method, of class HashUtils.
   */
  @Test
  public void testHexSHA512() {
    System.out.println("hexSHA512");
    String source = "hello world";
    String expResult = "309ecc489c12d6eb4cc40f50c902f2b4d0ed77ee511a7c7a9bcd3ca86d4cd86f989dd35bc5ff499670da34255b45b0cfd830e81f605dcf7dc5542e93ae9cd76f".toUpperCase();
    String result = HashUtils.hexSHA512(source);
    assertEquals(expResult, result);
  }
}