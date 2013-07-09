/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fratuz610
 */
public class HashHelperTest {
  
  public HashHelperTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  /**
   * Test of SHA256 method, of class HashHelper.
   */
  @Test
  public void testSHA256() {
    System.out.println("SHA256");
    HashHelper instance = new HashHelper("hello-world");
    byte[] result = instance.SHA256();
    assertTrue(result.length == 32);
    
    instance = new HashHelper("hello-world".getBytes());
    result = instance.SHA256();
    assertTrue(result.length == 32);
  }
}
