/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainWindowView;

/**
 *
 * @author frascog
 */
public class MainWindowController {

    private MainWindowView mainView;
    private LoadFileController loadFileController;

    public MainWindowController() {
        loadFileController = new LoadFileController(this);
    }
    
    public MainWindowView getMainWindow() {
        if (mainView == null) {
            this.mainView = new MainWindowView(this);
        }
        return mainView;
    }

    public void findFiles() {
        loadFileController.Load();
    }
}
