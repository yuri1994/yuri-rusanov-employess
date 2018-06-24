package gui;/*
    Created by y.rusanov on 24.06.2018
*/

import filter.FilterProject;
import model.TeamProject;
import read.ReadProjFile;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SimpleGUI extends JPanel implements ActionListener {

    private JFileChooser fileChooser;
    private JButton loadButton;
    private JTable table;
    private DefaultTableModel  defaultTableModel;
    public SimpleGUI() {
        super(new GridLayout(1,0));
        fileChooser = new JFileChooser();
        loadButton = new JButton("Load text file");
        loadButton.addActionListener(this);

        JPanel jPanelButton = new JPanel();
        jPanelButton.add(loadButton);
        String[] columnNames = {"Employee ID #1",
                "Employee ID #2",
                "Project ID",
                "Days worked"};

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        defaultTableModel.addColumn("Employee ID #1");
        defaultTableModel.addColumn("Employee ID #2");
        defaultTableModel.addColumn("Project ID");
        defaultTableModel.addColumn("Days worked");

        table.setPreferredScrollableViewportSize(new Dimension(640, 480));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        jPanelButton.add(scrollPane);
        add(jPanelButton);
        //add(scrollPane);
    }

    private void addData(TeamProject teamProject){

        Object[] data =
                {teamProject.getEmpl1(), teamProject.getEmpl2(), teamProject.getProject(), teamProject.getDaysOnTeam()};

        defaultTableModel.addRow(data);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadButton){

            int returnVal = fileChooser.showOpenDialog(SimpleGUI.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                ReadProjFile readProjFile = new ReadProjFile();
                readProjFile.setSeparator(",");
                readProjFile.setFile(file);
                try {
                    readProjFile.process();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                FilterProject filterProject = new FilterProject(readProjFile.getProjects());
                TeamProject teamProject = filterProject.getTeamProject();
                addData(teamProject);
            }
        }
    }
}
