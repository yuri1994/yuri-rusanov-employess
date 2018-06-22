package main;

import model.Project;
import read.ReadProjFile;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (Project project : projects){
            long diff = project.getDateTo().getTime() - project.getDateFrom().getTime();
            int days = (int) TimeUnit.MILLISECONDS.toDays(diff);
            System.out.println(project.getProjId()+ " / " + project.getEmpId()+ " / "  + days);
        }

    }

}
