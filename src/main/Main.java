package main;

/*
  Created by y.rusanov on 22.06.2018
 */

import filter.FilterProject;
import gui.SimpleGUI;
import model.TeamProject;
import read.ReadProjFile;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame("Team Longest Period");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        SimpleGUI simpleGUI = new SimpleGUI();
        simpleGUI.setOpaque(true); //content panes must be opaque
        frame.setContentPane(simpleGUI);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
