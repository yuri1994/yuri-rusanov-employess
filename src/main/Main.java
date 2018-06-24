package main;

/*
  Created by y.rusanov on 22.06.2018
 */

import filter.FilterProject;
import model.TeamProject;
import read.ReadProjFile;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        ReadProjFile readProjFile = new ReadProjFile();
        readProjFile.setSeparator(",");
        readProjFile.setPath("src/data.txt");

        try {
            readProjFile.process();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FilterProject filterProject = new FilterProject(readProjFile.getProjects());
        TeamProject teamProject = filterProject.getTeamProject();
        System.out.println(" Employee ID #1: " + teamProject.getEmpl1() + " Employee ID #2: " + teamProject.getEmpl2() + " Project ID: " +
                teamProject.getProject() + " Days worked: "+ teamProject.getDaysOnTeam());

    }
}
