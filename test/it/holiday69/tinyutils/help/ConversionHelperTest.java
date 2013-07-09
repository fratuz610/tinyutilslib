/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.holiday69.tinyutils.help;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author fratuz610
 */
public class ConversionHelperTest {
  
  public ConversionHelperTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }
  
  private ConversionHelper _strictConvHelper = new ConversionHelper(true);
  private ConversionHelper _looseConvHelper = new ConversionHelper(true);
  
  /**
   * Test of stringToInt method, of class ConversionHelper.
   */
  @Test
  public void testStringToInt() {
    System.out.println("stringToInt");
    assertEquals((Integer) 100, (Integer) _strictConvHelper.stringToInt("100"));
    assertEquals(null, (Integer) _strictConvHelper.stringToInt(null));
    assertEquals(null, (Integer) _strictConvHelper.stringToInt("hello"));
  }

  /**
   * Test of stringToLong method, of class ConversionHelper.
   */
  @Test
  public void testStringToLong() {
    
    System.out.println("stringToLong");
    /*String value = "";
    ConversionHelper instance = new ConversionHelper();
    Long expResult = null;
    Long result = instance.stringToLong(value);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");*/
  }

  /**
   * Test of stringToBoolean method, of class ConversionHelper.
   */
  @Test
  public void testStringToBoolean() {
    System.out.println("stringToBoolean");
    /*String value = "";
    ConversionHelper instance = new ConversionHelper();
    Boolean expResult = null;
    Boolean result = instance.stringToBoolean(value);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");*/
  }

  /**
   * Test of stringToFloat method, of class ConversionHelper.
   */
  @Test
  public void testStringToFloat() {
    System.out.println("stringToFloat");
    /*String value = "";
    ConversionHelper instance = new ConversionHelper();
    Float expResult = null;
    Float result = instance.stringToFloat(value);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");*/
  }
}
