package main;

import model.Project;
import read.ReadProjFile;

import java.io.IOException;
import java.util.LinkedList;

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

        LinkedList<Project>  projects = new LinkedList<>();
        projects = readProjFile.getProjects();

        for (Project project : projects){
            System.out.println(project.projId + " / " + project.empId + " / " + project.dateFrom + " / " + project.dateTo);
        }
    }

}
