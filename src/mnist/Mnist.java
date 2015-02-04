/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnist;

import Controller.MainWindowController;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author frascog
 */
public class Mnist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Mnist");
        mainWindow.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });        
        MainWindowController controller = new MainWindowController();
        mainWindow.getContentPane().add(controller.getMainWindow(),BorderLayout.CENTER); // add my top panel in the center
        mainWindow.pack();
        mainWindow.setExtendedState(mainWindow.getExtendedState()|JFrame.MAXIMIZED_BOTH ); // maxiumizes window
        mainWindow.setVisible(true);
    }
    
}
