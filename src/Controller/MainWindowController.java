/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SupportClasses.IDXFileReader;
import View.MainWindowView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author frascog
 */
public class MainWindowController {

    private MainWindowView mainView;
    private FileInputStream inImage;
    private FileInputStream inLabel;

    public MainWindowView getMainWindow() {
        if (mainView == null) {
            this.mainView = new MainWindowView(this);
        }
        return mainView;
    }

    public void findFiles() {
        FileSystemView filesys = FileSystemView.getFileSystemView();
        File[] roots = filesys.getRoots();
        String filePath = filesys.getHomeDirectory().getAbsolutePath() + "\\";
        String inputImagePath = filePath + "train-images.idx3-ubyte";
        String inputLabelPath = filePath + "train-labels.idx1-ubyte";
        if (!openFiles(inputImagePath, inputLabelPath)) {
            inputImagePath = getMainWindow().getFilePath("Image File", 0);
            inputLabelPath = getMainWindow().getFilePath("Label FIle", 0);
            openFiles(inputImagePath, inputLabelPath);
        }
        try {
            inImage = new FileInputStream(inputImagePath);
            inLabel = new FileInputStream(inputLabelPath);
        } catch (FileNotFoundException ex) {
            System.exit(-1);
        }
        IDXFileReader.readFiles(inImage, inLabel);
    }

    private boolean openFiles(String inputImagePath, String inputLabelPath) {
        try {
            inImage = new FileInputStream(inputImagePath);
            inLabel = new FileInputStream(inputLabelPath);
        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }
}
