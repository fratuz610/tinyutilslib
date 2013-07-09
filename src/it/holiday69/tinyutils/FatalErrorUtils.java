/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.holiday69.tinyutils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Stefano Fratini <stefano.fratini@yeahpoint.com>
 */
public class FatalErrorUtils {

  public static boolean systemLookAndFeelSet = false;

  public static void showFatalError(String errorString) {

    verifySystemLookAndFeel();

    JOptionPane.showMessageDialog(null,
        errorString,
        "Error",
        JOptionPane.ERROR_MESSAGE);
    
  }

  public static void showWarning(String warningString) {

    verifySystemLookAndFeel();

    JOptionPane.showMessageDialog(null,
        warningString,
        "Warning",
        JOptionPane.WARNING_MESSAGE);
  }

  private static void verifySystemLookAndFeel() {
    if(!systemLookAndFeelSet) {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        systemLookAndFeelSet = true;
      } catch (Exception ex) {

      }
    }
  }
}
