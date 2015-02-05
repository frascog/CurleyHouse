/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import SupportClasses.IDXFileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author frascog
 */
public class LoadFileController implements Runnable{

    private MainWindowController controller;
    private FileInputStream inImage;
    private FileInputStream inLabel;

    public LoadFileController(MainWindowController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        IDXFileReader.readFiles(inImage, inLabel);
    }
    
    public void Load() {
        FileSystemView filesys = FileSystemView.getFileSystemView();
        File[] roots = filesys.getRoots();
        String filePath = filesys.getHomeDirectory().getAbsolutePath() + "\\";
        String inputImagePath = filePath + "train-images.idx3-ubyte";
        String inputLabelPath = filePath + "train-labels.idx1-ubyte";
        if (!openFiles(inputImagePath, inputLabelPath)) {
            inputImagePath = controller.getMainWindow().getFilePath("Image File", 0);
            inputLabelPath = controller.getMainWindow().getFilePath("Label FIle", 0);
            openFiles(inputImagePath, inputLabelPath);
        }
        try {
            inImage = new FileInputStream(inputImagePath);
            inLabel = new FileInputStream(inputLabelPath);
        } catch (FileNotFoundException ex) {
            System.exit(-1);
        }
        run();
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
