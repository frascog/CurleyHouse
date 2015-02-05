/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Greg
 */
public class ImageBowserController {
    
    private MainWindowController controller;
    private DefaultMutableTreeNode root;
    private DefaultTreeModel model;
    //private ComponentBrowserView componentBrowserView;
    private List<Image> images;

    public ImageBowserController(MainWindowController controller) {
        this.controller = controller;
        images = new ArrayList<Image>();
        initTreeRoot();
        model = new DefaultTreeModel(root);
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public DefaultTreeModel getModel() {
        return model;
    }

//    public JPanel getBrowser() {
//        if (componentBrowserView == null) {
//            componentBrowserView = new ComponentBrowserView(this);
//        }
//        return componentBrowserView;
//    }

    private void initTreeRoot() {
        //create root
        root = new DefaultMutableTreeNode("Image List");
        //create children
        DefaultMutableTreeNode unsorted = new DefaultMutableTreeNode("Unsorted");
        DefaultMutableTreeNode zeros = new DefaultMutableTreeNode("0");
        DefaultMutableTreeNode ones = new DefaultMutableTreeNode("1");
        DefaultMutableTreeNode twos = new DefaultMutableTreeNode("2");
        DefaultMutableTreeNode threes = new DefaultMutableTreeNode("3");
        DefaultMutableTreeNode fours = new DefaultMutableTreeNode("4");
        DefaultMutableTreeNode fives = new DefaultMutableTreeNode("5");
        DefaultMutableTreeNode sixes = new DefaultMutableTreeNode("6");
        DefaultMutableTreeNode sevens = new DefaultMutableTreeNode("7");
        DefaultMutableTreeNode eights = new DefaultMutableTreeNode("8");
        DefaultMutableTreeNode nines = new DefaultMutableTreeNode("9");
        root.add(unsorted);
        root.add(zeros);
        root.add(ones);
        root.add(twos);
        root.add(threes);
        root.add(fours);
        root.add(fives);
        root.add(sixes);
        root.add(sevens);
        root.add(eights);
        root.add(nines);
    }

    public DefaultTreeModel refreshTree() {
        this.initTreeRoot();
        model = new DefaultTreeModel(root);
        return this.getModel();
    }
}
